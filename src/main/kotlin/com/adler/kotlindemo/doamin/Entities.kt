package com.adler.kotlindemo.doamin

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
//r2dbc 中数据库中下划线的（_）实体类映射成驼峰，如下数据库中字段名created_user 实体中createdUser
@Table
data class StudentTest(
    @Id
    var id: Long,
    var name: String,
    var age: Int,
    var address: String,
//    @Column("created_user")
    var createdUser: String?,
//    @Column("created_at")
    var createdAt: LocalDateTime?,
//    @Column("updated_user")
    var updatedUser: String?,
//    @Column("updated_at")
    var updatedAt: LocalDateTime?

)