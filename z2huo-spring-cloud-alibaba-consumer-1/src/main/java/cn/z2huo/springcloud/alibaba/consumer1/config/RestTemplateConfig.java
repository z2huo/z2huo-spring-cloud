package cn.z2huo.springcloud.alibaba.consumer1.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean(name = "restTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "loadBalancedRestTemplate")
    @LoadBalanced
    public RestTemplate getLoadBalancedRestTemplate() {
        return new RestTemplate();
    }

}
