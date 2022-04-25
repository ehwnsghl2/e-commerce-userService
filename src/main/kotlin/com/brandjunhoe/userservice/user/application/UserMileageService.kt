package com.brandjunhoe.userservice.user.application

import com.brandjunhoe.userservice.common.exception.BadRequestException
import com.brandjunhoe.userservice.consumer.event.MileageSaveDTO
import com.brandjunhoe.userservice.user.domain.UserMileage
import com.brandjunhoe.userservice.user.domain.UserMileageRepository
import com.brandjunhoe.userservice.user.domain.nums.MileageStateNum
import com.brandjunhoe.userservice.user.domain.nums.MileageTypeNum
import org.springframework.stereotype.Service
import java.util.*

/**
 * Create by DJH on 2022/04/18.
 */
@Service
class UserMileageService(private val userMileageRepository: UserMileageRepository) {


    fun saveMileagePurchase(request: MileageSaveDTO) {
        when (request.state) {
            MileageStateNum.READY -> saveMileage(request)
            MileageStateNum.SAVE -> updateMileageSave(request)
            else -> IllegalArgumentException()
        }
    }

    fun saveMileageReview(request: MileageSaveDTO) {
        val userMileage = saveMileage(request)

        if (request.type == MileageTypeNum.PHOTO_REVIEW) {

        }

    }

    private fun saveMileage(request: MileageSaveDTO): UserMileage {
        if (existMileage(request)) throw BadRequestException("already orderProduct purchase mileage")
        return userMileageRepository.save(request.toEntity())
    }

    private fun updateMileageSave(request: MileageSaveDTO) {
        val userMileage = findById(request.id)
        userMileage.updateStateSave()
    }

    private fun findById(id: UUID): UserMileage = userMileageRepository.findById(id)
        ?: throw BadRequestException("already orderProduct purchase mileage")

    private fun existMileage(request: MileageSaveDTO): Boolean =
        userMileageRepository.existsByUsrIdAndOrderCodeAndProductCode(
            request.usrId,
            request.orderCode,
            request.productCode
        )


}