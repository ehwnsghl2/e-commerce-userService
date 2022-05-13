package com.brandjunhoe.userservice.mileage.application

import com.brandjunhoe.userservice.common.exception.BadRequestException
import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.consumer.event.MileageSaveDTO
import com.brandjunhoe.userservice.mileage.domain.UserMileage
import com.brandjunhoe.userservice.mileage.domain.UserMileageRepository
import com.brandjunhoe.userservice.mileage.domain.enums.MileageStateNum
import com.brandjunhoe.userservice.mileage.domain.enums.MileageTypeNum
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * Create by DJH on 2022/04/18.
 */
@Service
class UserMileageService(
    private val userRepository: UserRepository,
    private val userMileageRepository: UserMileageRepository
) {


    fun savePurchaseReady(request: MileageSaveDTO) {

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

    private fun saveMileage(request: MileageSaveDTO) {

        val usrId = findByUsrId(request.usrId)

        val createMileage = usrId.createMileageReady(
            request.orderCode,
            request.productCode,
            request.type,
            request.state,
            request.amount
        )

        findMileage(request.usrId, request.orderCode, request.productCode)?.run {
            throw BadRequestException("already orderProduct purchase mileage")
        } ?: userMileageRepository.save(createMileage)

    }


    private fun updateMileageSave(request: MileageSaveDTO) {
        val userMileage = findMileage(request.usrId, request.orderCode, request.productCode)
            ?: throw DataNotFoundException("user mileage not found")
        userMileage.updateStateSave()
    }

    private fun findMileage(usrId: UUID, orderCode: String, productCode: String): UserMileage? =
        userMileageRepository.findByUsrIdAndOrderCodeAndProductCode(
            usrId,
            orderCode,
            productCode
        )

    private fun findByUsrId(usrId: UUID) =
        userRepository.findById(usrId) ?: throw DataNotFoundException("user not found")


}