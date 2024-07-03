package com.knf.dev.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor implements HandlerInterceptor {

    //Intercepting requests before they reach the Controller handler method
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        try {
            System.out.println("Inside preHandle() : " +
                    "Before sending request to the Controller handler method");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /*
    Allows for the modification of model data or response headers by
    running after the controller handler method but before view rendering.
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        try {
            System.out.println("Inside postHandle() : After the Controller " +
                    "serves the request and before returning back " +
                    "response to the client)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    This method that is called once the handler is executed and view is rendered.
    Regardless of the success or failure of the handler, always executes for
    resource management, logging, and cleanup tasks.
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        try {
            System.out.println("Inside afterCompletion() : " +
                    "After the request and Response is completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 