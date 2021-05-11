package com.locnv.Controller.web;

import com.locnv.Model.New;
import com.locnv.service.INewCategoryService;
import com.locnv.service.INewService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeWebNew", value = {"/tin-tuc","/chi-tiet-tin-tuc"})
public class NewController extends HttpServlet {
    @Inject
    private INewCategoryService newCategoryService;
    @Inject
    private INewService newService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer req = request.getRequestURL();
        request.setAttribute("newcategory",newCategoryService.findAll());
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
    }
}
