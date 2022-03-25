package com.example.ego.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    /** 添加到spring容器中
    */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
     public DataSource druidDatasource(){
         return new DruidDataSource();
     }

}
