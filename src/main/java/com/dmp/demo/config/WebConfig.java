package com.dmp.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.dmp.demo.fliter.GreetingFilter;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
	    final RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
	    requestMappingHandlerMapping.setRemoveSemicolonContent(false); // <<< this
	    return requestMappingHandlerMapping;
	}
	
	@Bean
    public FilterRegistrationBean greetingFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //registrationBean.setName("greet");
        GreetingFilter greetingFilter = new GreetingFilter();
        registrationBean.setFilter(greetingFilter);
        //registrationBean.setOrder(1);
        return registrationBean;
    }

}
