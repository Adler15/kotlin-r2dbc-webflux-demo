package com.adler.kotlindemo.controller

import com.adler.kotlindemo.config.DemoProperties
import com.adler.kotlindemo.doamin.StudentTest
import com.adler.kotlindemo.service.TestService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Api(tags = ["kotlin的demo代码"])
@RestController
@RequestMapping("demo")
class TestController(
    private val testService: TestService,
    private val demoProperties: DemoProperties
) {

    @ApiOperation("查询所有数据(不分页)")
    @GetMapping("all")
    fun findAll(): Flux<StudentTest> {
        return testService.findAll()
    }

    @ApiOperation("查询所有数据(分页)")
    @GetMapping("allPage")
    fun findAllPage(
        @RequestParam(defaultValue = "1") current: Long,
        @RequestParam(defaultValue = "2") size: Long
    ): Flux<StudentTest> {
        return testService.findAll().skip((current - 1) * size).take(size)
    }

    @ApiOperation("根据创建人查询数据")
    @GetMapping("findByCreatedUser")
    fun findByCreatedUser(@RequestParam createdUser: String): Flux<StudentTest> {
        return testService.findByCreatedUser(createdUser)
    }

    @ApiOperation("从配置文件中取数据")
    @GetMapping("properties")
    fun getFromProperties(): Mono<String> {
        val t = demoProperties.test
        return Mono.just("从配置文件中读取的数据为demo.test:$t")
    }


}