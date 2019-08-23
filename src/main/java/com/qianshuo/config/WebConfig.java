package com.qianshuo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author cheng
 * @className: WebConfig
 * @description: 静态资源配置类
 * @dateTime 2018/4/19 17:59
 */
@Component
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 日志管理
     */
    private Logger log = LoggerFactory.getLogger(WebConfig.class);


    @Autowired
    MyInterceptor myInterceptor;

    /**
     * @description:
     * @author cheng
     * @dateTime 2018/4/19 17:59
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("配置静态资源所在目录");
        // 和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//        registry.addResourceHandler("*.png").addResourceLocations("classpath:/templates/picture/");
//        registry.addResourceHandler("*.jpg").addResourceLocations("classpath:/templates/picture/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("pages/login");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("进入拦截器");
//        InterceptorRegistration interceptorRegistration=registry.addInterceptor(myInterceptor);
//        interceptorRegistration.addPathPatterns("*.do");
//        interceptorRegistration.excludePathPatterns("*.do");
//        interceptorRegistration.excludePathPatterns("*.js");
//        interceptorRegistration.excludePathPatterns("/web/");

    }


    //    允许的路径
    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.do");
        servletServletRegistrationBean.addUrlMappings("/index");
//        servletServletRegistrationBean.addUrlMappings("/**","/");

        servletServletRegistrationBean.addUrlMappings("*.jpg","*.png","*.js","*.css","*.woff","*.woff2","*.ttf");
//        servletServletRegistrationBean.addUrlMappings("*.png");
//        servletServletRegistrationBean.addUrlMappings("*.js");
//        servletServletRegistrationBean.addUrlMappings("*.css");
        return servletServletRegistrationBean;
    }

//    错误页配置，或者直接把error包移到templates下
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/pages/error/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/pages/error/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/pages/error/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }


}