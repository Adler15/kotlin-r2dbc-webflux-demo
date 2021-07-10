package com.adler.kotlindemo

import com.adler.kotlindemo.config.DemoProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import springfox.documentation.oas.annotations.EnableOpenApi

//项目启动后，浏览器输入后续网址查看swagger的接口文档：http://localhost:9999/swagger-ui/#
@SpringBootApplication
@EnableOpenApi
@EnableConfigurationProperties(DemoProperties::class)
@EnableR2dbcRepositories
class KotlindemoApplication

fun main(args: Array<String>) {
	runApplication<KotlindemoApplication>(*args)
}
