package com.locnv.Controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locnv.Model.ProductCategory;
import com.locnv.service.IProductCategoryService;
import com.locnv.util.HttpUtil;
import com.locnv.util.StringRemove;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "ProductCategoryAPI", value = {"/api-productcategory"})
public class ProductCategoryAPI extends HttpServlet {
    @Inject
    private IProductCategoryService categoryService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ProductCategory newcategory = HttpUtil.jsonToModel(request.getReader(),ProductCategory.class);
        newcategory.setTitle(StringRemove.removeAccent(newcategory.getName()));
        newcategory.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newcategory.setShowOnHome(true);
        newcategory.setStatus(true);
        newcategory = categoryService.add(newcategory);
        ObjectMapper obj = new ObjectMapper();
        obj.writeValue(response.getOutputStream(),newcategory);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ProductCategory newcategory = HttpUtil.jsonToModel(request.getReader(),ProductCategory.class);
        newcategory.setTitle(StringRemove.removeAccent(newcategory.getName()));
        newcategory.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        boolean isSuccess = categoryService.update(newcategory);
        response.getOutputStream().print("Update Status : " + (isSuccess ? "Succesfully" : "Failed"));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ProductCategory newcategory = HttpUtil.jsonToModel(request.getReader(),ProductCategory.class);
        boolean isSuccess = categoryService.delete(newcategory.getID());
        response.getOutputStream().print("Delete Status : " + (isSuccess ? "Succesfully" : "Failed"));
    }
}
