package com.jifang.spittr.config;

import com.jifang.spittr.filter.MyFilter;
import com.jifang.spittr.servlet.MyServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * 通过实现WebApplicationInitializer来配置额外的Servlet和Filter
 * author: jifang
 * date: 18-4-9 下午3:39
 */

public class MyServletInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        //配置自己的Servlet
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        myServlet.setLoadOnStartup(1);
        myServlet.addMapping("/myServlet/*");
        //配置自己的Filter
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        myFilter.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "myServlet");
    }
}
