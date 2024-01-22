package com.boot.basic.config;

import static org.springdoc.core.utils.Constants.ALL_PATTERN;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfiguration {

    @Value("${springdoc.version}")
    private String appVersion;

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("springbasic-public")
                .pathsToMatch(ALL_PATTERN)
                .packagesToScan("com.boot.basic")
                .build();
    }

    @Bean
    public OpenAPI springBasicOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("SpringBasic API")
                        .description("Spring basic sample application")
                        .version(appVersion)
                        .license(new License().name("no license")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringBasic Wiki Documentation")
                        .url("https://github.com/springdoc/springdoc-openapi-demos/tree/2.x/demo-spring-boot-3-webmvc"));
    }
}
