package cn.z2huo.netflix.eureka.client.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EurekaClientApplication.class, args);
        Environment environment = context.getEnvironment();
        System.out.println(environment);
    }

}
