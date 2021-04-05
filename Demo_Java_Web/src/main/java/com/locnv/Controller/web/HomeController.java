package com.locnv.Controller.web;

import com.locnv.Model.User;
import com.locnv.service.IUserService;
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

@WebServlet(name = "HomeWeb", value = {"/trang-chu","/thoat"})
public class HomeController extends HttpServlet {
    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer req = request.getRequestURL();
        if(req.toString().contains("/thoat")){
            SessionUtil.getInstance().removeValue(request,"USER");
            response.sendRedirect(request.getContextPath() + "/trang-chu");
            return;
        }
        getServletContext().getRequestDispatcher("/views/web/home.jsp").forward(request,response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ParaRequestUtil.paraToModel(User.class,request);
        user = userService.findUser(user.getUserName(),user.getPassword(),1);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject obj = new JSONObject();
        if(user != null){
            obj.put("isSuccess", true);
            obj.put("message","");
            obj.put("url","/trang-chu");
            SessionUtil.getInstance().putValue(request,"USER",user);
        }else {
            obj.put("isSuccess", false);
            obj.put("message","Tài khoản hoặc mật khẩu không đúng ahihi");
        }
        response.getWriter().print(obj);
    }
}
