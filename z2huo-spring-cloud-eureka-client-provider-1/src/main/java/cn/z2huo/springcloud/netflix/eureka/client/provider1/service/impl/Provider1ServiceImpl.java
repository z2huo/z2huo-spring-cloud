package cn.z2huo.springcloud.netflix.eureka.client.provider1.service.impl;

import cn.z2huo.springcloud.netflix.eureka.client.provider1.service.Provider1Service;
import org.springframework.stereotype.Service;

@Service
public class Provider1ServiceImpl implements Provider1Service {

    @Override
    public String provider1Method1(String string) {
        return "provider1Method1, " + string;
    }

    @Override
    public String provider1Method2(String string) {
        return "provider1Method2, " + string;
    }

}
