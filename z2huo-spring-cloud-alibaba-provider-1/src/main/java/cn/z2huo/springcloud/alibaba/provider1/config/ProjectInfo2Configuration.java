package cn.z2huo.springcloud.alibaba.provider1.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "project")
public class ProjectInfo2Configuration {

    private String name;

    private String id;

}
