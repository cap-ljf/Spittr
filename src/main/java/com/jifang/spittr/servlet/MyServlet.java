package com.jifang.spittr.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * author: jifang
 * date: 18-4-9 下午3:40
 */

public class MyServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("Hello, this is myServlet!");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
