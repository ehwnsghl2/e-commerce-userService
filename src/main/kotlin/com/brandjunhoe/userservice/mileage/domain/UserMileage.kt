package com.brandjunhoe.userservice.mileage.domain

import com.brandjunhoe.userservice.common.domain.DateColumnEntity
import com.brandjunhoe.userservice.mileage.domain.enums.MileageStateNum
import com.brandjunhoe.userservice.mileage.domain.enums.MileageTypeNum
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_mileage")
class UserMileage(

    @Column(name = "usr_id", nullable = false)
    val usrId: UUID,

    @Column(name = "order_product_code", length = 255, nullable = false)
    val orderProductCode: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "enum", nullable = false)
    val type: MileageTypeNum,

    state: MileageStateNum,

    @Column(name = "amount", nullable = false)
    val amount: BigDecimal,

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()


) : DateColumnEntity() {

    @Enumerated(EnumType.STRING)
    @Column(name = "state", columnDefinition = "enum", nullable = false)
    final var state: MileageStateNum? = null
        private set

    fun updateStateSave() {
        this.state = MileageStateNum.SAVE
    }

}

