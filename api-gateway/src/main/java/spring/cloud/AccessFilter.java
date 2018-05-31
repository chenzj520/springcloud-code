package spring.cloud;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {

	
	public Object run() {
		
//		RequestContext ctx = RequestContext.getCurrentContext();
//		HttpServletRequest request = ctx.getRequest();
//		String accessToken = request.getParameter("accessToken");
//		if(StringUtils.isBlank(accessToken)){
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseStatusCode(401);
//			return null;
//		}
		doSomeThing();
		return null;
	}
	private void doSomeThing() {
		throw new RuntimeException("运行时错误");
	}

	public boolean shouldFilter() {
		
		return true;
	}

	@Override	
	public int filterOrder() {
		
		return 0;
	}

	@Override
	public String filterType() {
		return "pre"; 
	}

}
