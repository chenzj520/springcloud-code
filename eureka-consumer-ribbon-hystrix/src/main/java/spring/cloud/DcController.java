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
		 * �������ʧ�ܵ�ʱ��ͻ����ָ���ķ���(fallback)�����һЩ��Ϣ
		 * Hystrix Ĭ�ϳ�ʱʱ��Ϊ���������Ĭ��ʱ��û�з�����Ϣ�ͻص���������û�в鵽Ĭ��ʱ���Ƕ��ٺ���
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