package com.adler.kotlindemo.dao

import com.adler.kotlindemo.doamin.StudentTest
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import reactor.core.publisher.Flux

interface TestRepository : ReactiveSortingRepository<StudentTest, Long> {

    fun findByCreatedUser(createdUser: String): Flux<StudentTest>;
}