package com.example.springbootdemo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author yuanhp
 * @Date 2022/03/01 16:05
 * @Version 1.0
 */
// 启动时加载类
@Configuration
// 启用Swagger API文档
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Phish Detect API管理")
                .description("API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("https://github.com/huapingz")
                .version("1.0")
                .contact(new Contact("yuanhp", "https://github.com/huapingz", "yuanhp@pcl.ac.cn"))
                .build();
    }

}
