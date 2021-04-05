package com.locnv.Controller.admin;

import com.locnv.Model.AdminUser;
import com.locnv.Model.User;
import com.locnv.service.IAdminUserService;
import com.locnv.service.IUserService;
import com.locnv.util.ParaRequestUtil;
import com.locnv.util.SessionUtil;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserController", value = {"/admin-useradmin","/admin-user"})
public class UserController extends HttpServlet {
    @Inject
    private IUserService userService;
    @Inject
    private IAdminUserService adminUserService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.equals("/admin-useradmin")){
            List<AdminUser> adminUser = new ArrayList<>();
            adminUser = adminUserService.findAll();
            request.setAttribute("user",adminUser);
            request.getRequestDispatcher("/views/admin/user/AdminUser.jsp").forward(request,response);
        }
        if(url.equals("/admin-user")){
            request.getRequestDispatcher("/views/admin/user/User.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
