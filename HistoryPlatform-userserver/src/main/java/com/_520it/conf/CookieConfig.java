package com._520it.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by 超哥 on 2019/4/26.
 */
@Configuration
public class CookieConfig {
    /**
     * 在配置文件配置APP.NAME参数即可
     */
    @Value("${app.name}")
    private String appName;
    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.getSessionCookieConfig().setName(appName);
            }
        };
    }
}
