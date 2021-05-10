package com.locnv.Controller.web;

import com.locnv.Model.Cart;
import com.locnv.Model.New;
import com.locnv.Model.Product;
import com.locnv.Model.User;
import com.locnv.service.*;
import com.locnv.util.ParaRequestUtil;
import com.locnv.util.SessionUtil;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeWeb", value = {"/trang-chu", "/thoat", "/san-pham","/chi-tiet-san-pham","/tin-tuc","/chi-tiet-tin-tuc","/gio-hang"})
public class HomeController extends HttpServlet {
    @Inject
    private IUserService userService;
    @Inject
    private IContactService contactService;
    @Inject
    private IProductCategoryService categoryService;
    @Inject
    private IProductService productService;
    @Inject
    private ISlideService slideService;
    @Inject
    private INewCategoryService newCategoryService;
    @Inject
    private INewService newService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer req = request.getRequestURL();
        request.setAttribute("contact", contactService.findContact());
        request.setAttribute("category", categoryService.findAll());
        request.setAttribute("slide", slideService.findAll());
        request.setAttribute("last", productService.findTop(5, "CreatedDate", "DESC"));
        request.setAttribute("views", productService.findTop(4, "Views", "DESC"));
        request.setAttribute("sales", productService.findTop(4, "SaleDate", "DESC"));
        request.setAttribute("news", productService.findTop(4, "ModifiedDate", "DESC"));

        request.setAttribute("newcategory",newCategoryService.findAll());
        if (req.toString().contains("/thoat")) {
            SessionUtil.getInstance().removeValue(request, "USER");
            response.sendRedirect(request.getContextPath() + "/trang-chu");
            return;
        }
        if (req.toString().contains("/trang-chu")) {
            getServletContext().getRequestDispatcher("/views/web/home.jsp").forward(request, response);
        }
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
            request.setAttribute("singleproduct",single);
            request.setAttribute("related",productService.findByCategoryID(single.getCategoryID()));
            getServletContext().getRequestDispatcher("/views/web/SingleProduct.jsp").forward(request,response);
        }
        if(req.toString().contains("/tin-tuc")){
            long cateid;
            request.setAttribute("lastnew",newService.findTop(8,"CreatedDate","DESC"));
            try{
                cateid = Long.parseLong(request.getParameter("icate"));
            }catch (NumberFormatException | NullPointerException e){
                request.setAttribute("news",newService.findAll());
                getServletContext().getRequestDispatcher("/views/web/News.jsp").forward(request, response);
                return;
            }
            request.setAttribute("news",newService.fingByCategoryID(cateid));
            getServletContext().getRequestDispatcher("/views/web/News.jsp").forward(request,response);
        }
        if(req.toString().contains("/chi-tiet-tin-tuc")){
            long id = Long.parseLong(request.getParameter("inew"));
            New news = newService.findByID(id);
            news.setListResult(newService.fingByCategoryID(news.getCategoryID()));
            request.setAttribute("news",news);
            getServletContext().getRequestDispatcher("/views/web/SingleNew.jsp").forward(request,response);
        }
        if(req.toString().contains("/gio-hang")){
            getServletContext().getRequestDispatcher("/views/web/Cart.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ParaRequestUtil.paraToModel(User.class, request);
        user = userService.findUser(user.getUserName(), user.getPassword(), 1);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject obj = new JSONObject();
        if (user != null) {
            obj.put("isSuccess", true);
            obj.put("message", "");
            obj.put("url", "/trang-chu");
            SessionUtil.getInstance().putValue(request, "USER", user);
        } else {
            obj.put("isSuccess", false);
            obj.put("message", "Tài khoản hoặc mật khẩu không đúng ahihi");
        }
        response.getWriter().print(obj);
    }
}
