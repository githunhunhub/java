package com.hunhun.javaweb.cache;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunhun.javaweb.HttpFilter;

/**
 * »º´æ¹ýÂËÆ÷
 * @author nerve
 *
 */
public class NoCacheFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println("cache filter");
		
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pregma", "no-cache");
		
		filterChain.doFilter(request, response);
	}


}
