package org.jiaopi;

import org.jiaopi.entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Repository;
//import tk.mybatis.spring.annotation.MapperScan;

@SpringBootConfiguration
@EnableAutoConfiguration
//@MapperScan(basePackages = {"org.jiaopi.dao"}, annotationClass = Repository.class)
@ComponentScan(basePackages = {"org.jiaopi"})
public class JoPeeDictApplication {
    public static void main(String[] args) {
        SpringApplication.run(JoPeeDictApplication.class, args);
    }

    @Bean
    public IdWorker idWorker () {
        return new IdWorker(0, 0);
    }
}
