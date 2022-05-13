package com.kms.self203.backend203self.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BackLogging implements HandlerInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(BackLogging.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        LOGGER.info("Request: " + request.getMethod() + ": " + request.getRequestURI());
        return true;
    }
}
