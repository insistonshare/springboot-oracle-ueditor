package com.zhx.help.conf;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by 11 on 2017/3/17.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration implements EnvironmentAware {

    private static Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    private Environment environment;
    private RelaxedPropertyResolver datasourcePropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.datasourcePropertyResolver = new RelaxedPropertyResolver(environment,
                "spring.datasource.");
    }

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl(datasourcePropertyResolver.getProperty("url"));
        dataSource.setUsername(datasourcePropertyResolver.getProperty("username"));
        dataSource.setPassword(datasourcePropertyResolver.getProperty("password"));
        dataSource.setDriverClassName(datasourcePropertyResolver.getProperty("driver-class-name"));
        return dataSource;
    }

}
