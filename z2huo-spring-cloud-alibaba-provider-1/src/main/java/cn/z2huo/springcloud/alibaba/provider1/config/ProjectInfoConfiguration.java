package cn.z2huo.springcloud.alibaba.provider1.config;

import cn.z2huo.springcloud.alibaba.provider1.entity.Project;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "project")
public class ProjectInfoConfiguration {

    private String name;

    private String id;

    @Bean
    @RefreshScope
    public Project getProject() {
        Project project = new Project();
        project.setProjectId("this project id is " + id);
        project.setProjectName("this project name is " + name);
        return project;
    }

}
