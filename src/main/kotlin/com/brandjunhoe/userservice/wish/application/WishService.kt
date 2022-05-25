package com.brandjunhoe.userservice.wish.application

import com.brandjunhoe.userservice.client.ProductImplClient
import com.brandjunhoe.userservice.common.exception.BadRequestException
import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.common.ext.convertStrToLocalDateTime
import com.brandjunhoe.userservice.user.application.exception.UserNotFoundException
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import com.brandjunhoe.userservice.wish.domain.Wish
import com.brandjunhoe.userservice.wish.presentation.dto.ReqWishSaveDTO
import com.brandjunhoe.userservice.wish.application.dto.WishDTO
import com.brandjunhoe.userservice.wish.application.exception.WishNotFoundException
import com.brandjunhoe.userservice.wish.application.exception.WishProductNotMatchingException
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

    fun save(req: ReqWishSaveDTO) {
        val user = findByUsrId(req.usrId)

        wishRepository.findByUsrIdAndProductCode(req.usrId, req.productCode)
            ?: throw BadRequestException("already wish")

        wishRepository.save(user.createWish(req.productCode))
    }

    @Transactional(readOnly = true)
    fun findAllByUsr(usrId: UUID): List<WishDTO> {

        val user = findByUsrId(usrId)
        val wishs = wishRepository.findByUsrId(user.id)
        val products = productClient.findProductByProductcodes(wishs.map { it.productCode })

        return wishs.map { wish ->
            products.find { product -> wish.productCode == product.productCode }?.let {
                WishDTO(wish.id!!, it.imagePath, it.name, convertStrToLocalDateTime(wish.regdate))
            } ?: throw WishProductNotMatchingException()

        }
    }

    fun deleteById(id: UUID) {
        wishRepository.deleteById(id)
    }

    private fun findByUsrId(usrId: UUID): User =
        userRepository.findById(usrId) ?: throw UserNotFoundException()

    private fun findById(id: UUID): Wish =
        wishRepository.findById(id) ?: throw WishNotFoundException()


}