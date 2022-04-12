package com.brandjunhoe.userservice.cart.application

import com.brandjunhoe.userservice.cart.domain.Cart
import com.brandjunhoe.userservice.client.ProductImplClient
import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.user.domain.*
import com.brandjunhoe.userservice.user.presentation.dto.ReqCartSaveDTO
import com.brandjunhoe.userservice.user.presentation.dto.ReqCartUpdateDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.*

@Service
class CartService(
    private val userRepository: UserRepository,
    private val cartRepository: CartRepository,
    private val productClient: ProductImplClient,
) {


    @Transactional
    fun save(usrId: UUID, req: ReqCartSaveDTO) {

        val user = findByUsrId(usrId)

        user.addCart(req.toEntity(BigDecimal.ZERO))

    }

    fun findAllByUsr(usrId: UUID) {

        val user = findByUsrId(usrId)

        val carts = user.carts

        // 카트 담은 날짜, 상품 메인 이미지, 상품 이름,
        val products = productClient.findProductByProductcodes(carts.map { it.productCode })


        carts.map {

            products.find { product -> it.productCode == product.productCode }?.let {

            }

        }


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