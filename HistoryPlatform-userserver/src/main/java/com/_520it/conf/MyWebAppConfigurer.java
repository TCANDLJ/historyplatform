package com._520it.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 超哥 on 2019/3/31.
 */
@Configuration
public class MyWebAppConfigurer  implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/detail.html").setViewName("detail");
        registry.addViewController("/history.html").setViewName("history");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/news.html").setViewName("news");
        registry.addViewController("/news_detail.html").setViewName("news_detail");
        registry.addViewController("/online.html").setViewName("online");
        registry.addViewController("/onlineChat.html").setViewName("onlineChat");
        registry.addViewController("/person.html").setViewName("person");
        registry.addViewController("/resgist.html").setViewName("resgist");
        registry.addViewController("/tribune.html").setViewName("tribune");
    }
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/person.html","/article/**")
                .excludePathPatterns("/article/queryDetail/**","/article/queryNews/**");

    }

}