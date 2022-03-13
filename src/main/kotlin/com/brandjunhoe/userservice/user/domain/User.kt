package com.brandjunhoe.userservice.user.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.userservice.user.domain.nums.GenderEnum
import com.brandjunhoe.userservice.user.domain.nums.GradeEnum
import com.brandjunhoe.userservice.user.domain.nums.JoinTypeEnum
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
class User(

        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "BINARY(16)")
        val id: UUID? = null,

        @Column(name = "email", length = 255, nullable = false)
        val email: String,

        @Column(name = "password", length = 255, nullable = false)
        val password: String,

        @Enumerated(EnumType.STRING)
        @Column(name = "grade", nullable = false)
        @ColumnDefault("FAMILY")
        val grade: GradeEnum,

        @Column(name = "name", length = 10)
        val name: String? = null,

        @Enumerated(EnumType.STRING)
        @Column(name = "gender")
        val gender: GenderEnum? = null,

        @Column(name = "phone", length = 11)
        val phone: String? = null,

        @Column(name = "birthday", length = 8)
        val birthday: String? = null,

        @Embedded
        var address: Address? = null,

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "term_date")
        var termDate: Date? = null,

        @Enumerated(EnumType.STRING)
        @Column(name = "join_type")
        val joinType: JoinTypeEnum? = null,

        @Column(name = "total_order_count")
        val totalOrderCount: Int = 0,

        @Column(name = "total_payment_count")
        val totalPaymentCount: Int = 0,

        @Column(name = "total_mileage_amount")
        val totalMileageAmount: BigDecimal = BigDecimal.ZERO,

        @Column(name = "total_order_amount")
        val totalOrderAmount: BigDecimal = BigDecimal.ZERO,

        @Column(name = "total_payment_amount")
        val totalPaymentAmount: BigDecimal = BigDecimal.ZERO,

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "login_date")
        var loginDate: Date? = null,

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "auth_date")
        var authDate: Date? = null

) : DateDeleteColumnEntity()

