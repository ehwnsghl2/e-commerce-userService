package com.brandjunhoe.userservice.wish.application

import com.brandjunhoe.userservice.client.ProductImplClient
import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.common.ext.convertStrToLocalDateTime
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import com.brandjunhoe.userservice.wish.domain.Wish
import com.brandjunhoe.userservice.wish.presentation.dto.ReqWishSaveDTO
import com.brandjunhoe.userservice.wish.application.dto.WishDTO
import com.brandjunhoe.userservice.wish.domain.WishRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class WishService(
    private val userRepository: UserRepository,
    private val wishRepository: WishRepository,
    private val productClient: ProductImplClient
) {

    @Transactional
    fun save(req: ReqWishSaveDTO) {
        val user = findByUsrId(req.usrId)
        user.addWish(req.productCode)
    }

    fun findAllByUsr(usrId: UUID): List<WishDTO?> {

        val user = findByUsrId(usrId)

        val wishs = user.wishs

        val products = productClient.findProductByProductcodes(wishs.map { it.productCode })

        return wishs.map { wish ->
            products.find { product -> wish.productCode == product.productCode }?.let {
                WishDTO(wish.id!!, it.imagePath, it.name, convertStrToLocalDateTime(wish.regdate))
            }
        }

    }

    @Transactional
    fun deleteById(id: UUID) {
        wishRepository.deleteById(id)
    }

    private fun findByUsrId(usrId: UUID): User =
        userRepository.findById(usrId) ?: throw DataNotFoundException("user not found")

    private fun findById(id: UUID): Wish =
        wishRepository.findById(id) ?: throw DataNotFoundException("user not found")


}