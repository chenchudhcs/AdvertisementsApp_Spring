package com.adserver.metadata;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

	

	 @Component
	 public class Filter extends GenericFilterBean 
	 
	 {

	     public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	         HttpServletResponse response = (HttpServletResponse) res;
	         response.setHeader("Access-Control-Allow-Origin", "http://localhost:5051");
	         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	         response.setHeader("Access-Control-Max-Age", "3600");
	         response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	         chain.doFilter(req, res);
	     }


	     public void destroy() {}

	 }
