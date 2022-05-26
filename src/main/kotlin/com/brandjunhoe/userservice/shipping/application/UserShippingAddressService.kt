package com.brandjunhoe.userservice.shipping.application

import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.shipping.application.dto.UserShippingAddressDTO
import com.brandjunhoe.userservice.shipping.domain.UserShippingAddressRepository
import com.brandjunhoe.userservice.shipping.presiontation.dto.UserShippingAddressSaveDTO
import com.brandjunhoe.userservice.shipping.presiontation.dto.UserShippingAddressUpdateDTO
import com.brandjunhoe.userservice.user.application.exception.UserNotFoundException
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserShippingAddressService(
    val userRepository: UserRepository,
    val userShippingAddressRepository: UserShippingAddressRepository
) {


    fun findByAllByUsr(usrId: UUID): List<UserShippingAddressDTO> =
        userShippingAddressRepository.findByUsrId(usrId).map {
            UserShippingAddressDTO(
                it.id,
                it.receiver,
                it.phone,
                it.address,
                it.default
            )
        }


    fun save(request: UserShippingAddressSaveDTO) {
        val user = userRepository.findById(request.usrId)
            ?: throw UserNotFoundException()

        userShippingAddressRepository.save(
            user.createShippingAddress(
                request.receiver,
                request.phone,
                request.address,
                request.default
            )
        )

    }

    @Transactional
    fun update(id: UUID, request: UserShippingAddressUpdateDTO) {
        val userShippingAddress = userShippingAddressRepository.findById(id)
            ?: throw DataNotFoundException("userShipping data not found ")

        userShippingAddress.update(request)

    }

    fun delete(id: UUID) {
        userShippingAddressRepository.deleteById(id)
    }


}