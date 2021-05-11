package com.locnv.Controller.web;

import com.locnv.Model.Product;
import com.locnv.service.IProductCategoryService;
import com.locnv.service.IProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeWebProduct", value = {"/san-pham","/chi-tiet-san-pham"})
public class ProductController extends HttpServlet {
    @Inject
    private IProductCategoryService categoryService;
    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer req = request.getRequestURL();
        if (req.toString().contains("/san-pham")) {
            Long cateid;
            try{
                cateid = Long.valueOf(request.getParameter("icate"));
            }catch (NumberFormatException | NullPointerException e){
                request.setAttribute("products",productService.findAll());
                getServletContext().getRequestDispatcher("/views/web/Products.jsp").forward(request, response);
                return;
            }
            request.setAttribute("catename",categoryService.findByID(cateid));
            request.setAttribute("products",productService.findByCategoryID(cateid));
            getServletContext().getRequestDispatcher("/views/web/Products.jsp").forward(request, response);
        }
        if (req.toString().contains("/chi-tiet-san-pham")){
            Long productid = Long.valueOf(request.getParameter("pid"));
            Product single = productService.findByID(productid);
            request.setAttribute("last", productService.findTop(5, "CreatedDate", "DESC"));
            request.setAttribute("singleproduct",single);
            request.setAttribute("related",productService.findByCategoryID(single.getCategoryID()));
            getServletContext().getRequestDispatcher("/views/web/SingleProduct.jsp").forward(request,response);
        }
    }
}
