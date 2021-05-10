package com.locnv.Controller.admin;

import com.locnv.Model.New;
import com.locnv.Model.NewCategory;
import com.locnv.service.INewCategoryService;
import com.locnv.service.INewService;
import com.locnv.util.ParaRequestUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewController", value = {"/admin-new","/admin-newcategory"})
public class NewController extends HttpServlet {
    @Inject
    private INewCategoryService newCategoryService;
    @Inject
    private INewService newService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.equals("/admin-newcategory")){
            NewCategory newcate = ParaRequestUtil.paraToModel(NewCategory.class,request);
            newcate.setListResult(newCategoryService.findAll());
            switch (newcate.getType()){
                case "list" -> {
                    request.setAttribute("newcate",
                            newcate);
                    request.getRequestDispatcher("/views/admin/new/NewCategory.jsp").forward(request, response);
                }
                case "detail" -> {
                    newcate = newCategoryService.findByID(newcate.getID());
                    request.setAttribute("model", newcate);
                    request.getRequestDispatcher("/views/admin/new/DetailNewCategory.jsp").forward(request, response);
                }
                case "add" -> {
                    request.setAttribute("model", newcate);
                    request.getRequestDispatcher("/views/admin/new/AddNewCategory.jsp").forward(request, response);
                }
                case "edit" -> {
                    newcate = newCategoryService.findByID(newcate.getID());
                    newcate.setListResult(newCategoryService.findAll());
                    request.setAttribute("model", newcate);
                    request.getRequestDispatcher("/views/admin/new/EditNewCategory.jsp").forward(request, response);
                }
            }
        }
        if(url.equals("/admin-new")){
            NewCategory newcate = new NewCategory();
            newcate.setListResult(newCategoryService.findAll());
            New news = ParaRequestUtil.paraToModel(New.class,request);
            switch (news.getType()){
                case "list" -> {
                    news.setTotal(newService.getTotalItem());
                    news.setListResult(newService.findRange(news));
                    request.setAttribute("news",news);
                    request.setAttribute("newcate",newcate);
                    request.getRequestDispatcher("/views/admin/new/New.jsp").forward(request,response);
                }
                case "detail" -> {
                    news = newService.findByID(news.getID());
                    request.setAttribute("model", news);
                    request.getRequestDispatcher("/views/admin/new/DetailNew.jsp").forward(request, response);
                }
                case "add" -> {
                    request.setAttribute("cate", newcate);
                    request.getRequestDispatcher("/views/admin/new/AddNew.jsp").forward(request, response);
                }
                case "edit" -> {
                    news = newService.findByID(news.getID());
                    request.setAttribute("model", news);
                    request.setAttribute("cate", newcate);
                    request.getRequestDispatcher("/views/admin/new/EditNew.jsp").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
