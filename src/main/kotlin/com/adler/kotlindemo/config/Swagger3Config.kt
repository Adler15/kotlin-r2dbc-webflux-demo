package com.adler.kotlindemo.config

import io.swagger.annotations.Api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class Swagger3Config {

    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .select() //api接口包扫描路径
            .apis(RequestHandlerSelectors.withClassAnnotation(Api::class.java))
            .apis(RequestHandlerSelectors.basePackage("com.adler"))
            .paths(PathSelectors.any())
            .build()
    }

    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("adler接口文档")
            .description("文档描述:端侧。。。")
            .version("1.0")
            .build()
    }

}