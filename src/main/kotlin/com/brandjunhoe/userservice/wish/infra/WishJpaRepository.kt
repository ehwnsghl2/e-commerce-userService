package com.brandjunhoe.userservice.wish.infra

import com.brandjunhoe.userservice.wish.domain.Wish
import com.brandjunhoe.userservice.wish.domain.WishRepository
import org.springframework.data.jpa.repository.JpaRepository

interface WishJpaRepository : JpaRepository<Wish, Long>, WishRepository {
}