package com.locnv.Controller.admin;

import com.locnv.Model.Product;
import com.locnv.Model.ProductCategory;
import com.locnv.service.IProductCategoryService;
import com.locnv.service.IProductService;
import com.locnv.util.ParaRequestUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductCategoryController", value = {"/admin-productcategory","/admin-product"})
public class ProductController extends HttpServlet {
    @Inject
    private IProductCategoryService productCategoryService;
    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();

        if(url.equals("/admin-productcategory")){
            ProductCategory procate = ParaRequestUtil.paraToModel(ProductCategory.class,request);
            procate.setListResult(productCategoryService.findAll());
            switch (procate.getType()) {
                case "list" -> {
                    request.setAttribute("model",
                            procate);
                    request.getRequestDispatcher("/views/admin/product/ProductCategory.jsp").forward(request, response);
                }
                case "edit" -> {
                    procate = productCategoryService.findByID(procate.getID());
                    request.setAttribute("model", procate);
                    request.getRequestDispatcher("/views/admin/product/EditProductCategory.jsp").forward(request, response);
                }
                case "detail" -> {
                    procate = productCategoryService.findByID(procate.getID());
                    request.setAttribute("model", procate);
                    request.getRequestDispatcher("/views/admin/product/DetailProductCategory.jsp").forward(request, response);
                }
            }
        }
        if(url.equals("/admin-product")){
            ProductCategory procate = new ProductCategory();
            Product product = ParaRequestUtil.paraToModel(Product.class,request);
            product.setTotal(productService.getTotalItem());
            product.setListResult(productService.findRange(product));
            procate.setListResult(productCategoryService.findAll());
            request.setAttribute("category",procate);
            request.setAttribute("product", product);
            request.getRequestDispatcher("/views/admin/product/Product.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
