package com.locnv.Controller.admin;

import com.locnv.Model.New;
import com.locnv.Model.NewCategory;
import com.locnv.service.INewCategoryService;
import com.locnv.service.INewService;
import com.locnv.util.ParaRequestUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
            newcate.setTotal(newCategoryService.getTotalItem());
            newcate.setListResult(newCategoryService.findRange(newcate));
//            newcate.setListResult(newCategoryService.findAll());
            request.setAttribute("newcate",newcate);
            request.getRequestDispatcher("/views/admin/new/NewCategory.jsp").forward(request,response);
        }
        if(url.equals("/admin-new")){
            New news = ParaRequestUtil.paraToModel(New.class,request);
            NewCategory newcate = new NewCategory();
            news.setTotal(newService.getTotalItem());
            news.setListResult(newService.findRange(news));
            newcate.setListResult(newCategoryService.findAll());
            request.setAttribute("news",news);
            request.setAttribute("newcate",newcate);
            request.getRequestDispatcher("/views/admin/new/New.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
