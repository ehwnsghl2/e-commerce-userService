package com.brandjunhoe.userservice.consumer

import com.brandjunhoe.userservice.consumer.dto.MileageSaveDTO
import com.brandjunhoe.userservice.mileage.application.UserMileageService
import com.brandjunhoe.userservice.mileage.domain.enums.MileageTypeNum
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.AcknowledgingMessageListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

/**
 * Create by DJH on 2022/04/18.
 */
@Component
class MileageSaveConsumer(
    private val mileageService: UserMileageService,
    private val objectMapper: ObjectMapper
) : AcknowledgingMessageListener<String, String> {


    @KafkaListener(
        topics = ["\${spring.kafka.consumer.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    override fun onMessage(data: ConsumerRecord<String, String>, acknowledgment: Acknowledgment?) {
        val mileageSaveDTO = objectMapper.readValue(data.value(), MileageSaveDTO::class.java)

        when (mileageSaveDTO.type) {
            MileageTypeNum.PRODUCT -> mileageService.savePurchaseReady(mileageSaveDTO)
            MileageTypeNum.TEXT_REVIEW, MileageTypeNum.PRODUCT -> mileageService.saveMileageReview(mileageSaveDTO)
            else -> IllegalArgumentException()
        }

        acknowledgment?.acknowledge()
    }


}


// {"usrId" : "6efb1bf8-d3d3-472a-876e-223a2798eb56", "orderCode" : "orderCode", "productCode" : "productCode",  "type" : "PRODUCT", "amount" : 1000}
