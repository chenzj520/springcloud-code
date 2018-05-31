package spring.cloud;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class ErrorFilter extends ZuulFilter {

	
	public Object run() {
		System.out.println("ddddddddddddddddddddddddddddddddddddddddddd");
		return null;
	}

	public boolean shouldFilter() {
		
		return true;
	}

	@Override	
	public int filterOrder() {
		
		return 10;
	}

	@Override
	public String filterType() {
		return "error"; 
	}

}
