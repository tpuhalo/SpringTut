package com.tpuhalo.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ExecutionTimerInterceptor implements HandlerInterceptor {

	private static Logger LOGGER = LoggerFactory.getLogger(ExecutionTimerInterceptor.class);
	long PREHANDLE_TIME = 0;
	long POSTHANDLER_TIME = 0;
	long AFTER_COMPLETION_TIME = 0;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		PREHANDLE_TIME = System.currentTimeMillis();
		LOGGER.info("Info message: PREHANDLE_TIME = " + PREHANDLE_TIME);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		POSTHANDLER_TIME = System.currentTimeMillis();
		LOGGER.info("Info message: POSTHANDLER_TIM =" + POSTHANDLER_TIME);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		AFTER_COMPLETION_TIME = System.currentTimeMillis();
		LOGGER.info("Info message: AFTER_COMPLETION_TIME = " + AFTER_COMPLETION_TIME);
		long HANDLE_EXECUTION_TIME = POSTHANDLER_TIME - PREHANDLE_TIME;
		long TOTAL_EXECUTION_TIME = AFTER_COMPLETION_TIME - POSTHANDLER_TIME;
		LOGGER.info("Info message: HANDLER_EXECUTION_TIME = " + HANDLE_EXECUTION_TIME);
		LOGGER.info("Info message: TOTAL_EXECUTION_TIME = " + TOTAL_EXECUTION_TIME);
	}

}
