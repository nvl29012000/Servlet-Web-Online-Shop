package com.locnv.Controller.admin;

import com.locnv.Model.AdminUser;
import com.locnv.Model.Bill;
import com.locnv.service.IBillDetailService;
import com.locnv.service.IBillService;
import com.locnv.util.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "BillController", urlPatterns = {"/admin-bill", "/admin-detail-bill", "/admin-confirm-bill", "/admin-successbill"})
public class BillController extends HttpServlet {
    @Inject
    private IBillService billService;
    @Inject
    private IBillDetailService billDetailService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer req = request.getRequestURL();
        if (req.toString().contains("/admin-bill")) {
            List<Bill> list = billService.getListBillByStatus(false);
            request.setAttribute("listBill", list);
            getServletContext().getRequestDispatcher("/views/admin/bill/Bill.jsp").forward(request, response);
        }
        if (req.toString().contains("/admin-detail-bill")) {
            Long id = Long.valueOf(request.getParameter("billID"));
            request.setAttribute("bill", billService.findByID(id));
            request.setAttribute("listBillDetail", billDetailService.findByBillID(id));
            getServletContext().getRequestDispatcher("/views/admin/bill/BillDetail.jsp").forward(request, response);
        }
        if (req.toString().contains("/admin-successbill")) {
            List<Bill> list = billService.getListBillByStatus(true);
            request.setAttribute("listBill", list);
            getServletContext().getRequestDispatcher("/views/admin/bill/BillDone.jsp").forward(request, response);
        }
        if (req.toString().contains("/admin-confirm-bill")) {
            Long id = Long.valueOf(request.getParameter("billID"));
            AdminUser ses = (AdminUser) SessionUtil.getInstance().getValue(request,"ADMINUSER");
            billService.updateBill(id, ses.getUsername(), new Timestamp(System.currentTimeMillis()));
            response.sendRedirect(request.getContextPath() + "/admin-bill");
        }
    }
}
