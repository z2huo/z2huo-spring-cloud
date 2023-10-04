package cn.z2huo.springcloud.netflix.eureka.client.provider1.controller;

import cn.z2huo.springcloud.netflix.eureka.client.provider1.service.Provider1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Provider1Controller {

    @Value("${provider.instance.name}")
    private String instanceName;

    private final Provider1Service provider1Service;

    @GetMapping("/provider1/method1")
    public String provider1Method1() {
        return provider1Service.provider1Method1(instanceName);
    }

    @GetMapping("/provider1/method2")
    public String provider1Method2() {
        return provider1Service.provider1Method2(instanceName);
    }

}
