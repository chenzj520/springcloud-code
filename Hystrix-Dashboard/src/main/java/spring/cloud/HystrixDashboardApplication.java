
package spring.cloud;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
@EnableHystrix
public class HystrixDashboardApplication  {

	public static void main(String[] args) {
		new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
	}
}