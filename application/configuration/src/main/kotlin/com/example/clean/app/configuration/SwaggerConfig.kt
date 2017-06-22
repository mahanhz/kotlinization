package com.example.clean.app.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfiguration.Constants.NO_SUBMIT_METHODS
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.clean.app.web.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
    }

    // Make Swagger read-only when in production
    @Bean
    @Profile("production")
    fun uiConfig(): UiConfiguration {
        return UiConfiguration(null, NO_SUBMIT_METHODS)
    }
}