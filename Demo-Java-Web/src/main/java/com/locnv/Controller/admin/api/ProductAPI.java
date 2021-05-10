package com.locnv.Controller.admin.api;

import com.locnv.Model.AdminUser;
import com.locnv.Model.Product;
import com.locnv.Model.ProductCategory;
import com.locnv.service.IProductService;
import com.locnv.util.HttpUtil;
import com.locnv.util.ParaRequestUtil;
import com.locnv.util.SessionUtil;
import com.locnv.util.StringRemove;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "ProductAPI", value = {"/api-product-new","/api-product-edit","/api-product-delete"})
public class ProductAPI extends HttpServlet {
    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Product newproduct = HttpUtil.jsonToModel(request.getReader(),Product.class);
        newproduct.setTitle(StringRemove.removeAccent(newproduct.getName()));
        newproduct.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        AdminUser ses = (AdminUser) SessionUtil.getInstance().getValue(request,"ADMINUSER");
        newproduct.setCreatedBy(ses.getUsername());
        newproduct = productService.add(newproduct);
        JSONObject obj = new JSONObject();
        if(newproduct != null){
            obj.put("isSuccess", true);
            obj.put("message","Thêm thành công");
            obj.put("url","/admin-product?type=list");
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
        Product product = HttpUtil.jsonToModel(request.getReader(),Product.class);
        assert product != null;
        product.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        AdminUser ses = (AdminUser)SessionUtil.getInstance().getValue(request,"ADMINUSER");
        product.setModifiedBy(ses.getUsername());
        boolean isSuccess = productService.update(product);
        JSONObject obj = new JSONObject();
        if(isSuccess){
            obj.put("isUpdate", true);
            obj.put("url","/admin-product?type=list");
        }else{
            obj.put("isUpdate", false);
        }
        response.getWriter().print(obj);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Product product = HttpUtil.jsonToModel(request.getReader(),Product.class);
        assert product != null;
        boolean isSuccess = productService.delete(product.getID());
        JSONObject obj = new JSONObject();
        if(isSuccess){
            obj.put("isDelete", true);
        }else{
            obj.put("isUpdate", false);
        }
        response.getWriter().print(obj);
    }
}
