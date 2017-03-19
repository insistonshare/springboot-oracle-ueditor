package com.zhx.help.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.MultipartConfigElement;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
public class WebAppConfig implements EnvironmentAware {

    private static Logger log = LoggerFactory.getLogger(WebAppConfig.class);

    @Value("${spring.http.multipart.max-file-size}")
    private String maxFileSize;
    @Value("${spring.http.multipart.max-request-size}")
    private String maxRequestSize;

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(this.maxFileSize);
        factory.setMaxRequestSize(this.maxRequestSize);
//        factory.setLocation(this.fileLocation);
        return factory.createMultipartConfig();
    }
}
