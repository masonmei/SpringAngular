package com.igitras.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mason on 2/2/15.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter extends OncePerRequestFilter{ //implements Filter {
    private static final String ORIGIN = "Origin";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-auth-token");

        if(request.getMethod().equals("OPTIONS")){

            response.getWriter().print("OK");
            response.getWriter().flush();
        } else {
            filterChain.doFilter(request, response);
        }
    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(
//            ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse rsp = (HttpServletResponse) response;
//        rsp.setHeader("Access-Control-Allow-Origin", "*");
//        rsp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        rsp.addHeader("Access-Control-Allow-Credentials", "true");
//        rsp.setHeader("Access-Control-Max-Age", "3600");
//        rsp.setHeader("Access-Control-Allow-Headers", "x-auth-token");
//
//
//        if(req.getMethod().equals("OPTIONS")){
//
//            response.getWriter().print("OK");
//            response.getWriter().flush();
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
}
