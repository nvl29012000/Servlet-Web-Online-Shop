package com.locnv.Controller.admin;

import com.locnv.Model.AdminUser;
import com.locnv.service.IAdminUserService;
import com.locnv.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
