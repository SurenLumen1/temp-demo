package com.lumen.dssh.orchestrator.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class DHOrchConfigAdapter implements WebMvcConfigurer {
    @Autowired
    MobileApiInterceptorHandler mobileApiInterceptorHandler;

    @Autowired
    DhApiInterceptorHandler dhApiInterceptorHandler;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mobileApiInterceptorHandler).addPathPatterns("/consmobile/**");
        registry.addInterceptor(dhApiInterceptorHandler).addPathPatterns("/**").excludePathPatterns("/consmobile/**");
    }
}
