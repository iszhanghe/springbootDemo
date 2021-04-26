package com.ssy.restfuluser.swaggerconfig;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: Swagger配置类
 * @author: zhanghe
 * @date: 2020/4/3 10:28
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 读取配置文件中 swagger 开关参数的值
    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).host("restful-user")
                .enable(swaggerEnable)                  // 是否启用 Swagger
                .apiInfo(apiInfo())
                //.groupName("swagger-example-service") // 项目组名
                .select()                               // 选择那些路径和api会生成document
//                .apis(RequestHandlerSelectors.any())    // 对所有api进行监控
                .apis(RequestHandlerSelectors.basePackage("com.ssy.restfuluser.controller"))
                .paths(PathSelectors.any())             // 对所有路径进行监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/actuator.*")))//actuator路径跳过
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-example-service")           // 文档标题
                .description("This is a swagger project.")  // 文档描述
                .contact("程序员Today")
                .version("1.0.0")                           // 文档版本
                .build();
    }

}
