package com.jifang.spittr.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * author: jifang
 * date: 18-4-9 下午3:52
 */

public class MyFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        String site = filterConfig.getInitParameter("Site");
        // 输出初始化参数
        LOG.info("网站名称: {}", site);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("Hello, this is myFilter!/n");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
