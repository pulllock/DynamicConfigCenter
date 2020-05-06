package me.cxis.dcc.sample;

import me.cxis.dcc.spring.EnableDCC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
// xml配置文件方式
// @ImportResource(value = {"classpath:dcc-spring.xml"})
// 注解方式启用
@EnableDCC
public class DynamicConfigCenterSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicConfigCenterSampleApplication.class, args);
    }
}
