package com.brandjunhoe.userservice.user.infra

import com.brandjunhoe.userservice.user.domain.Wish
import com.brandjunhoe.userservice.user.domain.WishRepository
import org.springframework.data.jpa.repository.JpaRepository

interface WishJpaRepository : JpaRepository<Wish, Long>, WishRepository {
}