package com.brandjunhoe.userservice.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Configuration
class Config {

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}