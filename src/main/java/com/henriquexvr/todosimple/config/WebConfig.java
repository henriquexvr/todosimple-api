package com.henriquexvr.todosimple.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**"); //Qualquer requisição que vier de fora, a partir do "/**", tudo ta liberado para ser acessado
    }
}
