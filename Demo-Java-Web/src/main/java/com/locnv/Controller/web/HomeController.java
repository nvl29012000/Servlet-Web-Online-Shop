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

@WebServlet(name = "HomeWeb", value = {"/trang-chu", "/thoat","/gio-hang"})
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

        if (req.toString().contains("/thoat")) {
            SessionUtil.getInstance().removeValue(request, "USER");
            response.sendRedirect(request.getContextPath() + "/trang-chu");
            return;
        }
        if (req.toString().contains("/trang-chu")) {
            getServletContext().getRequestDispatcher("/views/web/home.jsp").forward(request, response);
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
