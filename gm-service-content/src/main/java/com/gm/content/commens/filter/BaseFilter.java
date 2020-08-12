package com.gm.content.commens.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Order(1) //多个filter的时候,该序号越小,越早执行
@WebFilter(filterName = "BaseFilter", urlPatterns = "/*")
public class BaseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Map<String, String[]> parameterMap = servletRequest.getParameterMap();

//        parameterMap.forEach((k, v) -> {
//
//            for (String s : v) {
//
//
//            }
//            parameterMap.put(k, v);
//        });

        filterChain
                .doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

}
