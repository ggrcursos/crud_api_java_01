package com.crud.ApiCrud.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI canalhaApiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Example")
                                .description("API responsible for managing requests to save, insert , update and remove product")
                                .version("v1")
                                .license(
                                        new License()
                                                .name("Proprietary License")
                                                .url("http://website.com"))
                                .contact(new Contact().name("Crud-Api").email("any@gmail.com")));
    }
}