package com.brandjunhoe.userservice.mileage.infra

import com.brandjunhoe.userservice.mileage.domain.UserMileage
import com.brandjunhoe.userservice.mileage.domain.UserMileageRepository
import org.springframework.data.jpa.repository.JpaRepository

interface UserMileageJpaRepository : JpaRepository<UserMileage, Long>, UserMileageRepository {

}