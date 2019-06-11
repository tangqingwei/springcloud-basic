package com.qige.book.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(PostFilter.class);
	
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 打印请求的信息
	 */
	public Object run() throws ZuulException {
		logger.info("-------------------pre2-------------------");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
