package com.sutdy.config;

import com.study.service.UserService3;
import com.sutdy.service.UserServiceImpl3;
import org.apache.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName("rpc_provider3");
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
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig=new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20884);
        return protocolConfig;
    }
    /**
     * 元数据中心配置
     * 接口详细信息
     * */
    @Bean
    public MetadataReportConfig metadataReportConfig(){
        MetadataReportConfig metadataReportConfig=new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://139.224.49.74:2181");
        return metadataReportConfig;
    }
    @Bean
    public ServiceConfig<UserService3> serviceConfig(UserService3 userService3){
        ServiceConfig serviceConfig=new ServiceConfig();
        serviceConfig.setInterface(UserService3.class);
        serviceConfig.setRef(userService3);
        MethodConfig methodConfig=new MethodConfig();
        methodConfig.setName("selectAll");
        List<MethodConfig> list=Arrays.asList(methodConfig);
        serviceConfig.setMethods(list);
        return serviceConfig;
    }
}
