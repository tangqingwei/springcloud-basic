package com.qige.book.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AccessFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);
	
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 打印请求的信息
	 */
	public Object run() throws ZuulException {
		RequestContext rc =RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		logger.info("------------------pre---------------");
		String token = request.getParameter("token");
		if (token == null) {
			logger.warn("token is null ..........");
			rc.setSendZuulResponse(false);//代表结束请求
			rc.setResponseStatusCode(401);
			rc.setResponseBody("{\"result\":\"token is null\"}");
			rc.getResponse().setContentType("text/html;charset=utf-8");
		}else {
			//TODO redis 验证
			logger.info("token is ok");
		}
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
