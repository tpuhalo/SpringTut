package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("greeting", "Hallo Haloo Haalo HHalo");
		String location = request.getParameter("locationName");
		if (location != null) {
			request.setAttribute("locationName", location);
		}

		return true;
	}
}
