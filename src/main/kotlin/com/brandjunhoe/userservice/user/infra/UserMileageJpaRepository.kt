package com.brandjunhoe.userservice.user.infra

import com.brandjunhoe.userservice.user.domain.UserMileage
import com.brandjunhoe.userservice.user.domain.UserMileageRepository
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.data.jpa.repository.JpaRepository

interface UserMileageJpaRepository : JpaRepository<UserMileage, Long>, UserMileageRepository {

}