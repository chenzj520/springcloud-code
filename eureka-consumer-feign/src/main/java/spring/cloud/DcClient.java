package spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过@FeignClient注解来获取注册中心的一个服务名称
 * feign通过一个拦截器会解析对应服务eureka-client的IP和端口
 * Feign是基于Ribbon实现的
 * @author Administrator
 *
 */
@FeignClient("eureka-client")
public interface DcClient {

	/**
	 * 对应服务的访问地址
	 * @return
	 */
    @GetMapping("/dc")
    String consumer();

}