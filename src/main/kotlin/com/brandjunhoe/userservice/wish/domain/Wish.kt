package com.brandjunhoe.userservice.wish.domain

import com.brandjunhoe.userservice.common.domain.DateColumnEntity
import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.userservice.user.domain.User
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "wish")
class Wish(

    @Column(name = "usr_id", nullable = false)
    val usrId: UUID,

    @Column(name = "product_code", length = 255, nullable = false)
    val productCode: String,

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID? = null

) : DateColumnEntity()

