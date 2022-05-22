package com.brandjunhoe.userservice.shipping.infra

import com.brandjunhoe.userservice.shipping.domain.UserShippingAddress
import com.brandjunhoe.userservice.shipping.domain.UserShippingAddressRepository
import org.springframework.data.jpa.repository.JpaRepository

interface UserShippingAddressJpaRepository : JpaRepository<UserShippingAddress, Long>, UserShippingAddressRepository {
}