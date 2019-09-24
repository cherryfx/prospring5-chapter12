package com.cherry.prospring5.ch12.config;

import com.cherry.prospring5.ch12.services.SingerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class RmiClientConfig {
    @Bean("rmiSingerService")
    public SingerService singerService() {
        HttpInvokerProxyFactoryBean factoryBean =
                new HttpInvokerProxyFactoryBean();
        factoryBean.setServiceInterface(SingerService.class);
        factoryBean.setServiceUrl(
                "http://localhost:8080/ch12-0.0.1-SNAPSHOT/invoker/httpInvoker/singerService");
        factoryBean.afterPropertiesSet();
        return (SingerService) factoryBean.getObject();
    }
}
