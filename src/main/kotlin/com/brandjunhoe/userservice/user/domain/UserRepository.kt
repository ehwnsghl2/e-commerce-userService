package com.brandjunhoe.userservice.user.domain

interface UserRepository {
    fun findAll(): List<User>
}