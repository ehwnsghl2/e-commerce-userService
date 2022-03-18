package com.brandjunhoe.userservice.user.application

import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import com.brandjunhoe.userservice.user.domain.Wish
import com.brandjunhoe.userservice.user.domain.WishRepository
import com.brandjunhoe.userservice.user.presentation.dto.ReqWishSaveDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class WishService(
    private val userRepository: UserRepository,
    private val wishRepository: WishRepository
) {


    /**
     * 찜하기 저장
     * @param usrId UUID
     * @param req ReqWishSaveDTO
     */
    @Transactional
    fun save(usrId: UUID, req: ReqWishSaveDTO) {

        val user = findByUsrId(usrId)

        user.addWish(req.toEntity(usrId))

    }

    fun findAllByUsr(usrId: UUID) {

        val user = findByUsrId(usrId)

        val productCodes = user.wishs.map { it.productCode }

        // 찜한 날짜, 상품 메인 이미지, 상품 이름,

    }

    @Transactional
    fun deleteById(id: UUID) {

        val wish = findById(id)

        wish.delete()

    }


    private fun findByUsrId(usrId: UUID): User =
        userRepository.findById(usrId) ?: throw DataNotFoundException("user not found")

    private fun findById(id: UUID): Wish =
        wishRepository.findById(id) ?: throw DataNotFoundException("user not found")


}