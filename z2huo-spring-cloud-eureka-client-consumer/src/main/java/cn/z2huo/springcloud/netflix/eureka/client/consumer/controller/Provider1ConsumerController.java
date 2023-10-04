package cn.z2huo.springcloud.netflix.eureka.client.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Provider1ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

}
