package com.brandjunhoe.userservice.shipping.domain

import com.brandjunhoe.userservice.common.domain.DateColumnEntity
import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.userservice.mileage.domain.enums.MileageStateNum
import com.brandjunhoe.userservice.mileage.domain.enums.MileageTypeNum
import com.brandjunhoe.userservice.shipping.presiontation.dto.UserShippingAddressUpdateDTO
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_shipping_address")
class UserShippingAddress(

    @Column(name = "usr_id", nullable = false)
    val usrId: UUID,

    receiver: String,

    phone: String,

    address: Address,

    default: Boolean,

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()


) : DateColumnEntity() {

    @Column(name = "receiver", length = 30, nullable = false)
    var receiver: String = receiver
        protected set

    @Column(name = "phone", length = 30, nullable = false)
     var phone: String = phone
        protected set

    @Embedded
     var address: Address = address
        protected set


    @Column(name = "default")
     var default: Boolean = false
        protected set


    fun update(request: UserShippingAddressUpdateDTO) {
        request.receiver?.let { this.receiver = it }
        request.phone?.let { this.phone = it }
        request.address?.let { this.address = it }
        request.default?.let { this.default = it }
    }

}

