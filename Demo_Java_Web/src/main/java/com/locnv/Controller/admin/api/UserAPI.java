package com.locnv.Controller.admin.api;

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

@WebServlet(name = "UserAPI", value = {"/api-user-new", "/api-adminuser-active", "/api-adminuser-new"})
public class UserAPI extends HttpServlet {
    @Inject
    private IUserService userService;

    @Inject
    private IAdminUserService adminUserService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer url = request.getRequestURL();
        if (url.toString().contains("/api-user-new")) {
            User user = ParaRequestUtil.paraToModel(User.class, request);
            user.setStatus(true);
            User isExisteUser = userService.findUserByUserName(user.getUserName());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            JSONObject obj = new JSONObject();
            if (isExisteUser == null) {
                userService.add(user);
                SessionUtil.getInstance().putValue(request, "USER", user);
            } else {
                obj.put("existed", true);
                obj.put("message", "Tên tài khoản đã tồn tại");
            }
            response.getWriter().print(obj);
        } else if (url.toString().contains("/api-adminuser-new")) {
            AdminUser adminUser = ParaRequestUtil.paraToModel(AdminUser.class, request);
            adminUser.setStatus(true);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            AdminUser isExisted = adminUserService.findUserByUserName(adminUser.getUsername());
            JSONObject obj = new JSONObject();
            if (isExisted == null) {
                adminUserService.add(adminUser);
            } else {
                obj.put("existed", true);
                obj.put("message", "Tên tài khoản đã tồn tại");
            }
            response.getWriter().print(obj);
        } else if (url.toString().contains("/api-adminuser-active")) {
            AdminUser adminUser = ParaRequestUtil.paraToModel(AdminUser.class, request);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            adminUserService.changeStatus(adminUser);
            adminUser = adminUserService.findUserByID(adminUser.getID());
            JSONObject obj = new JSONObject();
            obj.put("Status", adminUser.isStatus());
            response.getWriter().print(obj);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
