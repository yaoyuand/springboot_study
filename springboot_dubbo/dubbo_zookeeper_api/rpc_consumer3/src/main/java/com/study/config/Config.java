package com.study.config;

import com.study.service.UserService3;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName("rpc_consumer3");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("139.224.49.74:2181");
        return registryConfig;
    }

    @Bean
    public ReferenceConfig<UserService3> referenceConfig(){
        ReferenceConfig referenceConfig=new ReferenceConfig();
        referenceConfig.setInterface(UserService3.class);
        return referenceConfig;
    }
}
