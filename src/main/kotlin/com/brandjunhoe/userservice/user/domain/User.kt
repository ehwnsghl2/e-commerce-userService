package com.brandjunhoe.userservice.user.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.userservice.mileage.domain.UserMileage
import com.brandjunhoe.userservice.mileage.domain.enums.MileageStateNum
import com.brandjunhoe.userservice.mileage.domain.enums.MileageTypeNum
import com.brandjunhoe.userservice.shipping.domain.Address
import com.brandjunhoe.userservice.shipping.domain.UserShippingAddress
import com.brandjunhoe.userservice.user.domain.nums.GenderEnum
import com.brandjunhoe.userservice.user.domain.nums.GradeEnum
import com.brandjunhoe.userservice.user.domain.nums.JoinTypeEnum
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "user")
@Where(clause = "deldate IS NULL")
@DynamicUpdate
class User(

    @Column(name = "email", length = 255, nullable = false)
    val email: String,

    @Column(name = "password", length = 255, nullable = false)
    val password: String,

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

) : DateDeleteColumnEntity() {

    @Version
    var version: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "grade", columnDefinition = "enum", nullable = false)
    @ColumnDefault("FAMILY")
    var grade: GradeEnum = GradeEnum.FAMILY
        protected set

    @Column(name = "name", length = 10)
    var name: String? = null
        protected set

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "enum")
    var gender: GenderEnum? = null
        protected set

    @Column(name = "phone", length = 11)
    var phone: String? = null
        protected set

    @Column(name = "birthday", length = 8)
    var birthday: String? = null
        protected set

    @Enumerated(EnumType.STRING)
    @Column(name = "join_type", columnDefinition = "enum")
    var joinType: JoinTypeEnum? = null
        protected set

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "login_date")
    var loginDate: Date? = null
        protected set

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "auth_date")
    var authDate: Date? = null
        protected set

    @Column(name = "total_order_count")
    var totalOrderCount: Int = 0
        protected set

    @Column(name = "total_payment_count")
    var totalPaymentCount: Int = 0
        protected set

    @Column(name = "total_mileage_amount")
    var totalMileageAmount: BigDecimal = BigDecimal.ZERO
        protected set

    @Column(name = "total_order_amount")
    var totalOrderAmount: BigDecimal = BigDecimal.ZERO
        protected set

    @Column(name = "total_payment_amount")
    var totalPaymentAmount: BigDecimal = BigDecimal.ZERO
        protected set

    fun login() {
        this.loginDate = Date()
    }

    fun createMileageReady(
        orderProductCode: String,
        type: MileageTypeNum,
        state: MileageStateNum,
        amount: BigDecimal
    ): UserMileage = UserMileage(this.id, orderProductCode, type, state, amount)

    fun createShippingAddress(
        receiver: String,
        phone: String,
        address: Address,
        default: Boolean
    ): UserShippingAddress =
        UserShippingAddress(this.id, receiver, phone, address, default)

    fun changeBirthday(birthday: String) {
        this.birthday = birthday
    }

}

