package com.locnv.Controller.admin.api;

import com.locnv.Model.AdminUser;
import com.locnv.Model.NewCategory;
import com.locnv.service.INewCategoryService;
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

@WebServlet(name = "NewCategoryAPI", value = {"/api-newcategory-new","/api-newcategory-edit","/api-newcategory-delete"})
public class NewCategoryAPI extends HttpServlet {
    @Inject
    private INewCategoryService categoryService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewCategory newcategory = HttpUtil.jsonToModel(request.getReader(), NewCategory.class);
        assert newcategory != null;
        newcategory.setTitle(StringRemove.removeAccent(newcategory.getName()));
        newcategory.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        AdminUser ses = (AdminUser) SessionUtil.getInstance().getValue(request,"ADMINUSER");
        newcategory.setCreatedBy(ses.getUsername());
        newcategory = categoryService.add(newcategory);
        JSONObject obj = new JSONObject();
        if(newcategory != null){
            obj.put("isSuccess", true);
            obj.put("message","Thêm thành công");
            obj.put("url","/admin-newcategory?type=list");
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
        NewCategory newcategory = HttpUtil.jsonToModel(request.getReader(),NewCategory.class);
        assert newcategory != null;
        newcategory.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        AdminUser ses = (AdminUser)SessionUtil.getInstance().getValue(request,"ADMINUSER");
        newcategory.setModifiedBy(ses.getUsername());
        boolean isSuccess = categoryService.update(newcategory);
        JSONObject obj = new JSONObject();
        if(isSuccess){
            obj.put("isUpdate", true);
            obj.put("url","/admin-newcategory?type=list");
        }else{
            obj.put("isUpdate", false);
        }
        response.getWriter().print(obj);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewCategory newcategory = HttpUtil.jsonToModel(request.getReader(),NewCategory.class);
        assert newcategory != null;
        boolean isSuccess = categoryService.delete(newcategory.getID());
        JSONObject obj = new JSONObject();
        if(isSuccess){
            obj.put("isDelete", true);
        }else{
            obj.put("isUpdate", false);
        }
        response.getWriter().print(obj);
    }
}
