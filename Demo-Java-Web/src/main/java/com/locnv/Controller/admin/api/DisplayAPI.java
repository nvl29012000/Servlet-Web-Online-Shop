package com.locnv.Controller.admin.api;

import com.locnv.Model.Contact;
import com.locnv.service.IContactService;
import com.locnv.util.HttpUtil;
import com.locnv.util.ParaRequestUtil;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisplayAPI",urlPatterns = {"/api-contact-edit"})
public class DisplayAPI extends HttpServlet {
    @Inject
    private IContactService contactService;
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contact contact = HttpUtil.jsonToModel(request.getReader(),Contact.class);
        contact.setStatus(true);
        boolean isSuccess = contactService.update(contact);
        JSONObject obj = new JSONObject();
        if(isSuccess){
            obj.put("isUpdate", true);
            obj.put("url","/admin-contact");
        }else{
            obj.put("isUpdate", false);
        }
        response.getWriter().print(obj);
    }
}
