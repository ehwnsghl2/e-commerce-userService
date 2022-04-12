package com.brandjunhoe.userservice.user.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.userservice.user.domain.nums.GenderEnum
import com.brandjunhoe.userservice.user.domain.nums.GradeEnum
import com.brandjunhoe.userservice.user.domain.nums.JoinTypeEnum
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_shipping_address")
class UserShippingAddress(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "name", length = 30, nullable = false)
    val name: String,

    @Column(name = "phone", length = 11)
    val phone: String? = null,

    @Embedded
    var address: Address? = null

) : DateDeleteColumnEntity()

