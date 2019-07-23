package com.yunusb.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("API document that project's").version("1.0.0").build();
  }

  @Bean
  public Docket custImp(){
    return null;
  }

}
