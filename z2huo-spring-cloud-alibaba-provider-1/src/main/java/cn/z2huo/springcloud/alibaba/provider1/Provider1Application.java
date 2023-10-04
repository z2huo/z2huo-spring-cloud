package cn.z2huo.springcloud.alibaba.provider1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class Provider1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Provider1Application.class, args);
        Environment environment = context.getEnvironment();
        log.info("active profiles contains: {}", Arrays.toString(environment.getActiveProfiles()));
        InetAddress local;
        try {
            local = InetAddress.getLocalHost();
            log.info("server start, URL is http://{}:{}", local.getHostAddress(), environment.getProperty("server.port"));
        } catch (UnknownHostException e) {
            log.error("InetAddress get failed", e);
        }
    }

}
