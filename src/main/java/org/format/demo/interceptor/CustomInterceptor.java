package org.format.demo.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/8/25 18:27 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class CustomInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //if (uri.endsWith("/login/auth") || uri.endsWith("/login/out")) {
        //    return true;
        //}

        if (uri.endsWith("/login/") || uri.endsWith("/login")) {
            if (null != request.getSession() && null != request.getSession().getAttribute("loginUser")) {
                response.sendRedirect(request.getContextPath() + "/index");
            } else {
                return true;
            }
        }

        if (null != request.getSession() && null != request.getSession().getAttribute("loginUser")) {
            return true;
        }

        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
