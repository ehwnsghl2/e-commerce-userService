package com.brandjunhoe.userservice.user.domain

import com.brandjunhoe.userservice.common.domain.DateColumnEntity
import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.userservice.user.domain.nums.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_mileage")
class UserMileage(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "usr_id", nullable = false)
    val usrId: UUID? = null,

    @Column(name = "order_code", length = 255, nullable = false)
    val orderCode: String,

    @Column(name = "product_code", length = 255, nullable = false)
    val productCode: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "enum", nullable = false)
    val type: MileageTypeNum? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "state", columnDefinition = "enum", nullable = false)
    val state: MileageStateNum? = null,

    @Column(name = "amount", nullable = false)
    val amount: BigDecimal


) : DateColumnEntity()

