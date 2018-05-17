
package spring.cloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

//    @Autowired
//    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
//        System.out.println(url);
//        return restTemplate.getForObject(url, String.class);
    	//Spring Cloud Ribbon��һ�������������ܹ����������ʵ�ʵ��õ�ʱ���Զ���ȥѡȡ����ʵ����
    	//����ʵ��Ҫ�����IP��ַ�Ͷ˿��滻����ķ��������Ӷ���ɷ���ӿڵĵ���
    	 return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}