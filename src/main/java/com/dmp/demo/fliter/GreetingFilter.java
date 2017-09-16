package com.dmp.demo.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GreetingFilter implements Filter {
	private final static Log log = LogFactory.getLog(GreetingFilter.class);
	
	private static int counter = 0;
	@Override
	public void destroy() {
		log.info("destroy...");
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		log.info("doFilter...");
		if (counter == 1) {
			log.info(counter++);
			throw new ServletException("doFilter...");
		}
		log.info(counter++);
		
		filterChain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("init...");
		
	}

}
