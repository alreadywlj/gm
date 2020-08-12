package com.gm.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author wlj
 */
@ServletComponentScan
@EnableAsync //开启异步注解功能
@EnableCaching //开启缓存功能
@SpringBootApplication
@ComponentScan(basePackages = {"com.gm.content"})
@MapperScan(basePackages = {"com.gm.content.dao.mapper"})
@EnableJpaAuditing
public class GmServiceContentApplication {
	public static void main(String[] args) {
		SpringApplication.run(GmServiceContentApplication.class, args);
	}
}
