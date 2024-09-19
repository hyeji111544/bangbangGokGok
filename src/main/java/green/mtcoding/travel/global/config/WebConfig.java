package green.mtcoding.travel.global.config;


import green.mtcoding.travel.global.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 1. 절대경로 file:///c:/upload/
        // 2. 상대경로 file:./upload/
        registry
                .addResourceHandler("/profileimg/**")
                .addResourceLocations("file:"+ "./profileimg/")
                .setCachePeriod(60*60) //초 단위 => 한시간
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}
