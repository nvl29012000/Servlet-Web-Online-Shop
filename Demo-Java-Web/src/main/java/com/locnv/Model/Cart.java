package com.locnv.Model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Long UserID;
    private String Name;
    private String Phone;
    private String Email;
    private String Address;
    private Timestamp CreatedDate;
    List<Product> productList = new ArrayList<>();
    private BigDecimal totalAmount;

    public Cart(){

    }

    public Cart(Long userID, String name, String phone, String email, String address, Timestamp createdDate, List<Product> productList, BigDecimal totalAmount) {
        UserID = userID;
        Name = name;
        Phone = phone;
        Email = email;
        Address = address;
        CreatedDate = createdDate;
        this.productList = productList;
        this.totalAmount = tongTien();
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Timestamp getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        CreatedDate = createdDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getTotalAmount() {
        return tongTien();
    }

    public void setTotalAmount() {
        this.totalAmount = tongTien();
    }

    public BigDecimal tongTien(){
        Double amount = 0.0;
        for(Product item : productList){
            amount +=  item.getPrice().doubleValue() * item.getQuantity();
        }
        return BigDecimal.valueOf(amount);
    }
    public String totalAmountToString(){
        return tongTien().toPlainString();
    }
}
