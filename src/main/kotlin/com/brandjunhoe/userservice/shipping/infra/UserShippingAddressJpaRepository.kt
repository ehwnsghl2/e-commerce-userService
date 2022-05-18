package com.brandjunhoe.userservice.shipping.infra

import com.brandjunhoe.userservice.shipping.domain.UserShippingAddress
import com.brandjunhoe.userservice.shipping.domain.UserShippingAddressRepository
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserShippingAddressJpaRepository : JpaRepository<UserShippingAddress, UUID>, UserShippingAddressRepository {
}