package cn.z2huo.springcloud.alibaba.provider1.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "project")
public class ProjectInfo2Configuration {

    private String name;

    private String id;

}
