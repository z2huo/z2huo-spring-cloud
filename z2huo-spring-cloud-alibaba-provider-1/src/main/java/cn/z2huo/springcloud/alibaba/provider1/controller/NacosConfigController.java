package cn.z2huo.springcloud.alibaba.provider1.controller;

import cn.z2huo.springcloud.alibaba.provider1.config.ProjectInfo2Configuration;
import cn.z2huo.springcloud.alibaba.provider1.config.ProjectInfoConfiguration;
import cn.z2huo.springcloud.alibaba.provider1.entity.Project;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@EnableConfigurationProperties(ProjectInfo2Configuration.class)
@RestController
@RequiredArgsConstructor
public class NacosConfigController {

    @Value("${project.name}")
    private String projectName;

    private final ProjectInfoConfiguration projectInfoConfiguration;

    private final ProjectInfo2Configuration projectInfo2Configuration;

    private final Project project;

    @GetMapping("/nacosConfig/project/name")
    public String configMethod() {
        return projectName + "_" + Math.abs(new Random().nextInt());
    }

    @GetMapping("/nacosConfig/configurationProperties")
    public String configMethod2() {
        return projectInfoConfiguration.toString();
    }

    @GetMapping("/nacosConfig/enableConfigurationProperties")
    public String configMethod3() {
        return projectInfo2Configuration.toString();
    }

    @GetMapping("/nacosConfig/beanConfig")
    @SentinelResource("nacosConfigBean")
    public String configMethod4() {
        return project.toString();
    }

}
