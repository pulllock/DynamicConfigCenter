package me.cxis.dcc.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dcc-spring.xml"})
public class DynamicConfigCenterSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicConfigCenterSampleApplication.class, args);
    }
}
