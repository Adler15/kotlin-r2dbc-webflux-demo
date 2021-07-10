package com.adler.kotlindemo.service

import com.adler.kotlindemo.dao.TestRepository
import com.adler.kotlindemo.doamin.StudentTest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class TestService(private val testRepository: TestRepository) {

    fun findAll(): Flux<StudentTest> {
        return testRepository.findAll()
    }

    fun findByCreatedUser(createdUser: String): Flux<StudentTest> {
        return testRepository.findByCreatedUser(createdUser);
    }
}