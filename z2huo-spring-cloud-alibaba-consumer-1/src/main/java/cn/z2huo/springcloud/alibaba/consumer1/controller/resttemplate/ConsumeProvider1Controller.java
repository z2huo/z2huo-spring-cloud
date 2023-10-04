package cn.z2huo.springcloud.alibaba.consumer1.controller.resttemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ConsumeProvider1Controller {

    public static final String PREFIX_URL = "http://alibaba-provider-1";

    private final RestTemplate restTemplate;

    private final RestTemplate loadBalancedRestTemplate;

    private final LoadBalancerClient loadBalancerClient;

    public ConsumeProvider1Controller(@Qualifier("restTemplate") RestTemplate restTemplate,
                                      @Qualifier("loadBalancedRestTemplate") RestTemplate loadBalancedRestTemplate,
                                      LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancedRestTemplate = loadBalancedRestTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping("/consumer1/provider1/method1/serviceInstance")
    public String method1() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-provider-1");
        String path = String.format("http://%s:%s/provider1/method1", serviceInstance.getHost(), serviceInstance.getPort());
        return restTemplate.getForObject(path, String.class);
    }

    @GetMapping("/consumer1/provider1/method1/loadBalanced")
    public String method1LoadBalanced() {
        return loadBalancedRestTemplate.getForObject(PREFIX_URL + "/provider1/method1", String.class);
    }

}
