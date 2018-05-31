package spring.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApplication {

	@RequestMapping("/hello")
	public String index(){
		return "hello worlasdfasdfsdafsdafd";
	}
}
