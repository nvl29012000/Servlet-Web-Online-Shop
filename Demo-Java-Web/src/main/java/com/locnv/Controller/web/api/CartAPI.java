package com.locnv.Controller.web.api;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.locnv.Model.Cart;
import com.locnv.Model.Product;
import com.locnv.service.IProductService;
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
import java.text.DecimalFormat;

@WebServlet(name = "CartController", value = {"/add-to-cart"})
public class CartAPI extends HttpServlet {
    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, "Cart");
        Product product = HttpUtil.jsonToModel(request.getReader(), Product.class);
        Product productnew  = productService.findByID(product.getID());
        productnew.setQuantity(product.getQuantity());
        boolean isExist = false;
        for (Product item : cart.getProductList()) {
            if (item.getID() == product.getID()) {
                item.setQuantity(item.getQuantity() + product.getQuantity());
                isExist = true;
            }
        }
        cart.getProductList().removeIf(x -> x.getQuantity() == 0);
        if(!isExist){
            cart.getProductList().add(productnew);
        }
        cart.setTotalAmount();
        SessionUtil.getInstance().putValue(request,"Cart",cart);
        response.getWriter().print(new Gson().toJson(cart));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, "Cart");
        Product product = HttpUtil.jsonToModel(request.getReader(), Product.class);
        JSONObject obj = new JSONObject();
        if(cart.getProductList().removeIf(x -> x.getID() == product.getID())){
            obj.put("isDelete",true);
        }
        else{
            obj.put("isDelete",false);
        }
        cart.setTotalAmount();
        obj.put("cart",new JSONObject(cart));
        SessionUtil.getInstance().putValue(request,"Cart",cart);
        response.getWriter().print(obj);
    }
}
