package com.zlx.interceptor;

import com.zlx.pojo.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查
 * 1、配置好拦截器要拦截的请求
 * 2、把拦截器放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    //    目标方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("被拦截的请求路径：" + requestURI);
        //登录检查逻辑
        HttpSession session = request.getSession();
        Admin admin =(Admin) session.getAttribute("admin");
        System.out.println(admin);
        if (admin!= null) {
            //放行
            return true;
        }
//        session.setAttribute("msg","请登录");
//        response.sendRedirect("/");
        request.setAttribute("msg", "请登录");
        request.getRequestDispatcher("/").forward(request, response);
        return false;

    }

    //目标方法之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("当前方法是postHandle");

    }

    //页面渲染完毕后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("当前方法是afterCompletion");
    }
}
