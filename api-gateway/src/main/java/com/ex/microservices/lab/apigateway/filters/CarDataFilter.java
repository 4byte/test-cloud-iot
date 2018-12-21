package com.ex.microservices.lab.apigateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER;

@Component
public class CarDataFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(CarDataFilter.class);

	@Override
	public boolean shouldFilter() {
//		RequestContext ctx = RequestContext.getCurrentContext();
//		HttpServletRequest request = ctx.getRequest();
//		log.info(request.getRequestURL().toString());
//		return request.getMethod().equals("GET") && request.getRequestURL().toString().equals("some-some");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}

	@Override
	public String filterType() {
		return ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		return SIMPLE_HOST_ROUTING_FILTER_ORDER - 1;
	}
}
