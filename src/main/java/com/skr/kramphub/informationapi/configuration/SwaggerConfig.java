package com.skr.kramphub.informationapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Config class for Swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Creates a new {@link Docket} for swagger documentation
     *
     * @return {@link Docket} instance
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

    /**
     * Method that defines api info for swagger
     *
     * @return instance of {@link ApiInfo}
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Rest API for Kramphub case")
                .description("This is an API which fetches data from external Api")
                .contact(new Contact("Sijumon Karyil Raju", null, "sijumon.skr@gmail.com"))
                .termsOfServiceUrl(null)
                .version("1.0.0")
                .build();
    }
}
