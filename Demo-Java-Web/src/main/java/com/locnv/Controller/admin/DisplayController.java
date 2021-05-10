package com.locnv.Controller.admin;

import com.locnv.service.IContactService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Display", urlPatterns = {"/admin-contact"})
public class DisplayController extends HttpServlet {
    @Inject
    private IContactService contactService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.equals("/admin-contact")){
            String type = "";
            try{
                type = request.getParameter("type").toString();
            }catch (NullPointerException e){
            }
            if(type.equals("edit")){
                Long id = Long.valueOf(request.getParameter("ID").toString());
                request.setAttribute("model",contactService.findByID(id));
                request.getRequestDispatcher("/views/admin/display/EditContact.jsp").forward(request,response);
            }else {
                request.setAttribute("model",contactService.findContact());
                request.getRequestDispatcher("/views/admin/display/Contact.jsp").forward(request,response);
            }
        }
    }
}
