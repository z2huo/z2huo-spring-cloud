package cn.z2huo.springcloud.netflix.eureka.client.consumer.controller;

import cn.z2huo.springcloud.netflix.eureka.client.consumer.EurekaClientConsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@Slf4j
@SpringBootTest(classes = EurekaClientConsumerApplication.class)
class Provider1ConsumerControllerTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void discover() {
        System.out.println(discoveryClient.description());
        System.out.println(discoveryClient.getServices());
        System.out.println(discoveryClient.getOrder());
        List<ServiceInstance> instanceList = discoveryClient.getInstances("eureka-client-provider-1");
        for (ServiceInstance serviceInstance : instanceList) {
            System.out.println(serviceInstance.getInstanceId());
            System.out.println(serviceInstance.getServiceId());
            System.out.println(serviceInstance.getMetadata());
            System.out.println(serviceInstance.getUri());
            break;
        }
        System.out.println(instanceList);
    }

}