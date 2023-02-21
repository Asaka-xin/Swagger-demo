package com.asaka.swaggerhello.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api() {return GroupedOpenApi.builder().group("all")
            .pathsToMatch("/**")
            .packagesToScan("com.asaka.swaggerhello.controller").build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("This is your title")
                        .version("Your Version")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Your Name")
                                .email("Your Email"))
                        .description("And your description"));

    }
}
