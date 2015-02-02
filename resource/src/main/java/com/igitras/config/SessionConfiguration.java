package com.igitras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Created by mason on 2/2/15.
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfiguration {

//    @Bean
//    @Order(0)
//    public FilterRegistrationBean filterRegistrationBean(SessionRepositoryFilter springSessionRepositoryFilter){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new DelegatingFilterProxy(springSessionRepositoryFilter));
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        return filterRegistrationBean;
//    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy(){
        return new HeaderHttpSessionStrategy();
    }



}
