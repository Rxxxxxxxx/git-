package com.hbxy.webstudy.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    public void init(FilterConfig fConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.write("Hello MyFilter");
    }
    public void destroy() {
    }
}