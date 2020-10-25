package com.qt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;

    }

    private ApiInfo metadata(){
        return new ApiInfoBuilder()
                       .title("Spring Boot Professor Server API")
                       .description("Description of Professor Server API")
                       .version("1.0")
                       .build();
    }

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                       .select()
                       .apis(RequestHandlerSelectors.any())
                       .paths(PathSelectors.any())
                       .build()
                       .apiInfo(metadata());
    }
}

