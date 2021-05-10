package com.locnv.Controller.admin.api;

import com.locnv.Model.AdminUser;
import com.locnv.Model.New;
import com.locnv.service.INewService;
import com.locnv.util.HttpUtil;
import com.locnv.util.SessionUtil;
import com.locnv.util.StringRemove;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "NewAPI", value = {"/api-new-new","/api-new-edit","/api-new-delete"})
public class NewAPI extends HttpServlet {
    @Inject
    private INewService newService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        New newNew = HttpUtil.jsonToModel(request.getReader(),New.class);
        newNew.setTitle(StringRemove.removeAccent(newNew.getName()));
        newNew.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        AdminUser ses = (AdminUser) SessionUtil.getInstance().getValue(request,"ADMINUSER");
        newNew.setCreatedBy(ses.getUsername());
        newNew = newService.add(newNew);
        JSONObject obj = new JSONObject();
        if(newNew != null){
            obj.put("isSuccess", true);
            obj.put("message","Thêm thành công");
            obj.put("url","/admin-new?type=list");
        }else{
            obj.put("isSuccess", false);
            obj.put("message","Có lỗi gì đó vui lòng thử lại sau");
        }
        response.getWriter().print(obj);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        New news = HttpUtil.jsonToModel(request.getReader(),New.class);
        assert news != null;
        news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        AdminUser ses = (AdminUser)SessionUtil.getInstance().getValue(request,"ADMINUSER");
        news.setModifiedBy(ses.getUsername());
        boolean isSuccess = newService.update(news);
        JSONObject obj = new JSONObject();
        if(isSuccess){
            obj.put("isUpdate", true);
            obj.put("url","/admin-new?type=list");
        }else{
            obj.put("isUpdate", false);
        }
        response.getWriter().print(obj);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        New news = HttpUtil.jsonToModel(request.getReader(),New.class);
        assert news != null;
        boolean isSuccess = newService.delete(news.getID());
        JSONObject obj = new JSONObject();
        if(isSuccess){
            obj.put("isDelete", true);
        }else{
            obj.put("isUpdate", false);
        }
        response.getWriter().print(obj);
    }
}
