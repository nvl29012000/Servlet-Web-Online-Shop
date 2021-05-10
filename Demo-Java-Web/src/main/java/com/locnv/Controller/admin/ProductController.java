package com.locnv.Controller.admin;

import com.locnv.Model.Product;
import com.locnv.Model.ProductCategory;
import com.locnv.service.IProductCategoryService;
import com.locnv.service.IProductService;
import com.locnv.util.ParaRequestUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

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
                    procate.setListResult(productCategoryService.findAll());
                    request.setAttribute("model", procate);
                    request.getRequestDispatcher("/views/admin/product/EditProductCategory.jsp").forward(request, response);
                }
                case "detail" -> {
                    procate = productCategoryService.findByID(procate.getID());
                    request.setAttribute("model", procate);
                    request.getRequestDispatcher("/views/admin/product/DetailProductCategory.jsp").forward(request, response);
                }
                case "add" -> {
                    request.setAttribute("model", procate);
                    request.getRequestDispatcher("/views/admin/product/AddProductCategory.jsp").forward(request, response);
                }
            }
        }
        if(url.equals("/admin-product")){
            ProductCategory procate = new ProductCategory();
            procate.setListResult(productCategoryService.findAll());
            Product product = ParaRequestUtil.paraToModel(Product.class,request);
            switch (product.getType()) {
                case "list" -> {
                    product.setTotal(productService.getTotalItem());
                    product.setListResult(productService.findRange(product));
                    procate.setListResult(productCategoryService.findAll());
                    request.setAttribute("category", procate);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("/views/admin/product/Product.jsp").forward(request, response);
                }
                case "detail" -> {
                    product = productService.findByID(product.getID());
                    request.setAttribute("model", product);
                    request.getRequestDispatcher("/views/admin/product/DetailProduct.jsp").forward(request, response);
                }
                case "add" -> {
                    request.setAttribute("cate", procate);
                    request.getRequestDispatcher("/views/admin/product/AddProduct.jsp").forward(request, response);
                }
                case "edit" -> {
                    product = productService.findByID(product.getID());
                    request.setAttribute("model", product);
                    request.setAttribute("cate", procate);
                    request.getRequestDispatcher("/views/admin/product/EditProduct.jsp").forward(request, response);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
