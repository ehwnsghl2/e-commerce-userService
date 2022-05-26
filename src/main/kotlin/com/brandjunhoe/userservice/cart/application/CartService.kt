package com.brandjunhoe.userservice.cart.application

import com.brandjunhoe.userservice.cart.application.dto.CartDTO
import com.brandjunhoe.userservice.cart.application.exception.CartNotFoundException
import com.brandjunhoe.userservice.cart.application.exception.CartProductNotMatchingException
import com.brandjunhoe.userservice.cart.domain.Cart
import com.brandjunhoe.userservice.cart.domain.CartRepository
import com.brandjunhoe.userservice.client.ProductImplClient
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import com.brandjunhoe.userservice.cart.presentation.dto.ReqCartSaveDTO
import com.brandjunhoe.userservice.cart.presentation.dto.ReqCartUpdateDTO
import com.brandjunhoe.userservice.user.application.exception.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CartService(
    private val userRepository: UserRepository,
    private val cartRepository: CartRepository,
    private val productClient: ProductImplClient,
) {


    @Transactional
    fun save(req: ReqCartSaveDTO) {
        val user = findByUsrId(req.usrId)

        val cart = cartRepository.findByUsrIdAndProductCodeAndItemCode(req.usrId, req.productCode, req.itemCode)

        cart?.run { addQuantity() }
            ?: cartRepository.save(user.createCart(req.productCode, req.itemCode, req.quantity))

    }

    @Transactional(readOnly = true)
    fun findAllByUsr(usrId: UUID): List<CartDTO> {

        val user = findByUsrId(usrId)
        val carts = cartRepository.findByUsrId(user.id)
        val products = productClient.findProductByProductcodes(carts.map { it.productCode })

        return carts.map { cart ->
            products.find { product -> cart.productCode == product.productCode }?.let {
                CartDTO(
                    cart.id!!,
                    it.productCode,
                    it.imagePath,
                    it.name,
                    it.retailPrice,
                    it.sellingPrice,
                    it.sellingState,
                    it.discountRate,
                    it.discountPrice,
                    it.soldOutState
                )
            } ?: throw CartProductNotMatchingException()
        }

    }

    @Transactional
    fun updateById(id: UUID, req: ReqCartUpdateDTO) {
        val cart = findById(id)
        cart.changeQuantity(req.quantity)
    }

    @Transactional
    fun deleteById(id: UUID) {
        val cart = findById(id)
        cart.delete()
    }

    private fun findByUsrId(usrId: UUID): User =
        userRepository.findById(usrId) ?: throw UserNotFoundException()

    private fun findById(id: UUID): Cart =
        cartRepository.findById(id) ?: throw CartNotFoundException()

}