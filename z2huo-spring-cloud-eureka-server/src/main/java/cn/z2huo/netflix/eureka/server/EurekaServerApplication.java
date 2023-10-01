package cn.z2huo.netflix.eureka.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) throws UnknownHostException {
        // spring cloud官网文档里面是这样启动的
//        new SpringApplicationBuilder(Application.class).web(true).run(args);

        ConfigurableApplicationContext context = SpringApplication.run(EurekaServerApplication.class, args);
        Environment environment = context.getEnvironment();
        InetAddress local = InetAddress.getLocalHost();
        log.info("server start, URL is http://{}:{}", local.getHostAddress(), environment.getProperty("server.port"));

        System.out.println(">>> environment");
        System.out.println(environment.getProperty("class"));
        System.out.println("> system properties");
        System.out.println(environment.getProperty("name"));
        System.out.println(environment.getProperty("age"));
        System.out.println(environment.getProperty("height"));
        System.out.println(environment.getProperty("liming.weight"));
        System.out.println("> args");
        System.out.println(Arrays.toString(args));
        System.out.println(environment.getProperty("me.weight"));
        System.out.println(environment.getProperty("she.weight"));
        System.out.println(environment.getProperty("liming.weight"));

        System.out.println();

        System.out.println(">>> system");
        System.out.println(System.getProperty("class"));
        System.out.println("> system properties");
        System.out.println(System.getProperty("name"));
        System.out.println(System.getProperty("age"));
        System.out.println(System.getProperty("height"));
        System.out.println(System.getProperty("liming.weight"));
        System.out.println("> args");
        System.out.println(Arrays.toString(args));
        System.out.println(System.getProperty("me.weight"));
        System.out.println(System.getProperty("she.weight"));
        System.out.println(System.getProperty("liming.weight"));
    }

}
