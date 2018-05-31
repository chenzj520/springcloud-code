package spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class DcController {

	@Autowired
	ConsumerService consumerService;

	@GetMapping("/consumer")
	public String dc() {
		return consumerService.consumer();
	}


	@Service
	class ConsumerService {

		@Autowired
		RestTemplate restTemplate;

		/**
		 * @HystrixCommand(fallbackMethod = "fallback")
		 * 如果调用失败的时候就会调用指定的方法(fallback)来输出一些信息
		 * Hystrix 默认超时时间为，如果超过默认时间没有返回信息就回调方法，还没有查到默认时间是多少毫秒
		 * @return
		 */
		@HystrixCommand(fallbackMethod = "fallback")
		public String consumer() {
			long start = System.currentTimeMillis(); 
			String forObject = restTemplate.getForObject("http://eureka-client/dc",
					String.class);
			long end = System.currentTimeMillis(); 
			System.out.println("Spend time : "+ (end - start)); 
			return forObject;
		}

		public String fallback() {
			return "fallback";
		}

	}
}