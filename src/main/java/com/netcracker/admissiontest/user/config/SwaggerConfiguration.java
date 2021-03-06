package com.netcracker.admissiontest.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration("UserSwaggerConfiguration")
@EnableSwagger2
public class SwaggerConfiguration {

/*    @Bean
    public Docket ingredientsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("com.netcracker.admissiontest.user"))
                .paths(regex("/.*"))
                .build()
                .groupName("ingredients")
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo());
    }*/

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(basePackage("com.netcracker.admissiontest"))
                .paths(regex("/.*"))
                .build();
    }




    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Ingredients REST API")
                .description("This API allows to perform all operations related to ingredients")
                .version("1.0")
                .build();
    }
}
