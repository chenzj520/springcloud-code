package spring.cloud;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
//    	int sleepTime = new Random().nextInt (3000);
//    	System.out.println("�ӳ�"+sleepTime);
//    	Thread.sleep(sleepTime);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}