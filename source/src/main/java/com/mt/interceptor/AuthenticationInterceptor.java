package com.mt.interceptor;

import com.mt.interceptor.scope.Protected;
import com.mt.interceptor.scope.Public;
import com.mt.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	private static final int PROTECTED_LEVEL = 1;
	private static final int PUBLIC_LEVEL = 0;
	private static final int DEFAULT_LEVEL = PROTECTED_LEVEL;

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);


	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/**
		 * 跨域设置
		 */
		/**
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		 response.setHeader("Access-Control-Max-Age", "-1");//OPTIONS检测缓存
		 response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With, token, sign, timestamp , sessionToken");
		 response.setHeader("Access-Control-Allow-Credentials", "true");
		 response.setHeader("XDomainRequestAllowed","1");
		 */

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Class<?> controllerClass = handlerMethod.getBean().getClass();
			final int level = getControllerLevel(controllerClass, handlerMethod.getMethod());
			Object user = request.getSession().getAttribute(Const.SESSION_KEY);
			if(level != PUBLIC_LEVEL && user == null){
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().print("{code:-9, message:'未登录，此操作需要先登录'}");
				return false;
			}
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	private int getControllerLevel(final Class<?> controllerClass, final Method controllermethod) throws Exception {
		if (controllermethod.isAnnotationPresent(Public.class)) {
			return PUBLIC_LEVEL;
		}
		if (controllermethod.isAnnotationPresent(Protected.class)) {
			return PROTECTED_LEVEL;
		}

		if (controllerClass.isAnnotationPresent(Public.class)) {
			return PUBLIC_LEVEL;
		}
		if (controllerClass.isAnnotationPresent(Protected.class)) {
			return PROTECTED_LEVEL;
		}

		return DEFAULT_LEVEL;
	}

}
