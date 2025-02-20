package com.korit.springboot_security.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        OpenAPI openAPI = new OpenAPI();
        openAPI.info(getInfo());

        return openAPI;
    }

    private Info getInfo() {

        Info info = new Info();
        info.setTitle("Spring Boot Security 수업");
        info.version("1.0.0");
        info.description("시큐리티 수업 내용입니다.");
        info.contact(getContact());
        return info;
    }

    private Contact getContact() {

        Contact contact = new Contact();
        contact.name("이재현");
        contact.email("wogus2974@naver.com");
        return contact;
    }

    private SecurityRequirement getSecurityRequirement() {
        return new SecurityRequirement().addList("Bearer Authentication");
    }
}
