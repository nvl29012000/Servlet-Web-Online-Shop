package com.locnv.Controller.web.api;

import com.locnv.Model.*;
import com.locnv.service.IBillDetailService;
import com.locnv.service.IBillService;
import com.locnv.service.IUserService;
import com.locnv.util.HttpUtil;
import com.locnv.util.SessionUtil;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "BillAPI",urlPatterns = {"/api-bill-add"})
public class BillAPI extends HttpServlet {
    @Inject
    private IUserService userService;
    @Inject
    private IBillService billService;
    @Inject
    private IBillDetailService billDetailService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Cart billadd = HttpUtil.jsonToModel(request.getReader(),Cart.class);
        Cart listDetailBill = (Cart) SessionUtil.getInstance().getValue(request,"Cart");
        billadd.setProductList(listDetailBill.getProductList());
        Bill newBill = new Bill();
        if(billadd.getUserID() != null){
            User infor = userService.findUserByID(billadd.getUserID());
            billadd.setName(infor.getName());
            billadd.setPhone(infor.getPhone());
            infor.setAddress(billadd.getAddress());
            infor.setEmail(billadd.getEmail());
            userService.updateUserInfor(infor);
            newBill.setUserID(infor.getID());
        }
        newBill.setName(billadd.getName());
        newBill.setPhone(billadd.getPhone());
        newBill.setAddress(billadd.getAddress());
        newBill.setEmail(billadd.getEmail());
//        newBill.setPayment("COD");
        newBill.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Bill inserted = billService.add(newBill);
        JSONObject obj = new JSONObject();
        if(inserted != null){
            for(Product item : listDetailBill.getProductList()){
                BillDetail detail = new BillDetail();
                detail.setBillID(inserted.getID());
                detail.setProductID(item.getID());
                detail.setPrice(item.getPrice());
                detail.setQuantity(item.getQuantity());
                if(billDetailService.add(detail) == null){
                    List<BillDetail>  wrongInsert = billDetailService.findByBillID(inserted.getID());
                    for(BillDetail a : wrongInsert){
                        billDetailService.deleteByID(a.getID());
                    }
                    billService.deleteByID(inserted.getID());
                    obj.put("Success",false);
                    break;
                }
            }
            obj.put("Success",true);
            obj.put("url", "/trang-chu");
            SessionUtil.getInstance().removeValue(request,"Cart");
        }
        else{
            obj.put("Success",false);
        }
        response.getWriter().print(obj);
    }
}
