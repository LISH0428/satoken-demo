package com.example.satokendemo;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SatokenDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SatokenDemoApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
        System.out.println("http://localhost:8083/swagger-ui.html");
    }

}
