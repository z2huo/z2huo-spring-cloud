package cn.z2huo.springcloud.alibaba.provider1.controller;

import cn.z2huo.springcloud.alibaba.provider1.service.Provider1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class Provider1Controller {

    @Value(value = "${provider.instance.name:provider1}")
    private String instanceName;

    @Value(value = "${server.port}")
    private String serverPort;

    private final Provider1Service provider1Service;

    @GetMapping("/provider1/method1")
    public String provider1Method1() {
        log.info("instance.name: {}", instanceName);
        return provider1Service.provider1Method1(serverPort);
    }

    @GetMapping("/provider1/method2")
    public String provider1Method2() {
        log.info("instance.name: {}", instanceName);
        return provider1Service.provider1Method2(serverPort);
    }

}
