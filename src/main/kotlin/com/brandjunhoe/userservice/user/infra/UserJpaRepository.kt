package com.brandjunhoe.userservice.user.infra

import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long>, UserRepository {
}