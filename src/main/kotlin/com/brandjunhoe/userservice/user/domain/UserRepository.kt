package com.brandjunhoe.userservice.user.domain

import java.util.*

interface UserRepository {
    fun findAll(): List<User>
    fun existsByEmail(email: String): Boolean
    fun save(user: User): User
    fun findByEmail(email: String): User?
    fun findById(id: UUID): User?
}