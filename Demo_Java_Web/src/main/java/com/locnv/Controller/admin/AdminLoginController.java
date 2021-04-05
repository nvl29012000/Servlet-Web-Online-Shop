package com.locnv.Controller.admin;

import com.locnv.Model.AdminUser;
import com.locnv.service.IAdminUserService;
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

@WebServlet(name = "Login", value = {"/login","/logout"})
public class AdminLoginController extends HttpServlet {
    @Inject
    private IAdminUserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer req = request.getRequestURL();
        if(req.toString().contains("/logout")){
            SessionUtil.getInstance().removeValue(request,"ADMINUSER");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        getServletContext().getRequestDispatcher("/views/admin/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminUser user = ParaRequestUtil.paraToModel(AdminUser.class,request);
        user = userService.findUser(user.getUsername(),user.getPassword(),1);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject obj = new JSONObject();
        if(user != null){
            obj.put("isSuccess", true);
            obj.put("message","");
            obj.put("url","/admin-home");
            SessionUtil.getInstance().putValue(request,"ADMINUSER",user);
        }else {
            obj.put("isSuccess", false);
            obj.put("message","Tài khoản hoặc mật khẩu không đúng");
        }
        response.getWriter().print(obj);
    }
}
