package com.komorebi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A");
    }

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(false)            // 是否启动Swagger
                .groupName("komorebi")
                .select()
                // RequestHandlerSelectors 配置要扫描接口的方式
                //   basePackage:指定要扫描的包
                //   any()：扫描全部
                //   none()：不扫描
                //   withClassAnnotation：扫描类上的注解
                //   withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.komorebi.controller"))
                // 过滤
//                .paths(PathSelectors.ant("/komorebi/**"))
                .build();
    }

    // 配置Swagger信息 apiInfo
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("komorebi", "http://www.baidu.com", "240553516");
        return new ApiInfo(
                "Komorebi API Document",
                "be the best",
                "v1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>()
        );
    }
}
