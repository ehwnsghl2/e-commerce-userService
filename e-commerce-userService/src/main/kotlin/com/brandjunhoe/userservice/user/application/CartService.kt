package com.brandjunhoe.userservice.user.application

import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.user.domain.*
import com.brandjunhoe.userservice.user.presentation.dto.ReqCartSaveDTO
import com.brandjunhoe.userservice.user.presentation.dto.ReqCartUpdateDTO
import com.brandjunhoe.userservice.user.presentation.dto.ReqWishSaveDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.*

@Service
class CartService(
    private val userRepository: UserRepository,
    private val cartRepository: CartRepository
) {


    @Transactional
    fun save(usrId: UUID, req: ReqCartSaveDTO) {

        val user = findByUsrId(usrId)

        user.addCart(req.toEntity(usrId, BigDecimal.ZERO))

    }

    fun findAllByUsr(usrId: UUID) {

        val user = findByUsrId(usrId)

        val productCodes = user.wishs.map { it.productCode }

        // 찜한 날짜, 상품 메인 이미지, 상품 이름,

    }

    @Transactional
    fun updateById(id: UUID, req: ReqCartUpdateDTO) {

        val cart = findById(id)

        cart.update(req.itemCode, req.quantity)

    }

    @Transactional
    fun deleteById(id: UUID) {

        val cart = findById(id)

        cart.delete()

    }


    private fun findByUsrId(usrId: UUID): User =
        userRepository.findById(usrId) ?: throw DataNotFoundException("user not found")

    private fun findById(id: UUID): Cart =
        cartRepository.findById(id) ?: throw DataNotFoundException("user not found")


}