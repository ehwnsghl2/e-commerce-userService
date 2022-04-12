package com.brandjunhoe.userservice.user.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import org.hibernate.annotations.GenericGenerator
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

    @Column(name = "receiver", length = 30, nullable = false)
    val receiver: String,

    @Column(name = "phone", length = 11)
    val phone: String? = null,

    @Embedded
    var address: Address? = null

) : DateDeleteColumnEntity()

