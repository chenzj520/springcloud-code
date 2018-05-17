package spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ͨ��@FeignClientע������ȡע�����ĵ�һ����������
 * feignͨ��һ���������������Ӧ����eureka-client��IP�Ͷ˿�
 * Feign�ǻ���Ribbonʵ�ֵ�
 * @author Administrator
 *
 */
@FeignClient("eureka-client")
public interface DcClient {

	/**
	 * ��Ӧ����ķ��ʵ�ַ
	 * @return
	 */
    @GetMapping("/dc")
    String consumer();

}