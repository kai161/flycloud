package com.nk.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2017/10/19.
 *
 * zuul过滤器添加
 */
public class PreRequsetFilter extends ZuulFilter {
    @Override
    public String filterType() {
     /* 过滤器类型：pre:请求执行之前filter
        route: 处理请求，进行路由
        post: 请求处理完成后执行的filter
        error:出现错误时执行的filter*/
        return "pre";
    }

    @Override
    public int filterOrder() {
        //filter执行顺序，通过数字指定
        return 50000;
    }

    @Override
    public boolean shouldFilter() {
        //filter是否需要执行 true执行 false 不执行
        return true;
    }

    @Override
    public Object run() {
        System.out.println("this is ZuulFilter");
        HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
        String requsetUrl= request.getRequestURI();
        String requestParam=request.getQueryString();
        System.out.println("requset url is : "+requsetUrl);
        System.out.println("requset Param is : "+requestParam);
        return null;
    }
}
