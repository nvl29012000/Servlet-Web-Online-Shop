package com.locnv.filter;

import com.locnv.Model.AdminUser;
import com.locnv.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        StringBuffer url = req.getRequestURL();
        if(url.toString().contains("/admin")){
            AdminUser adminUser = (AdminUser) SessionUtil.getInstance().getValue(req,"ADMINUSER");
            if(adminUser != null){
                chain.doFilter(request,response);
            }else {
                res.sendRedirect("/login");
            }
        }else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
