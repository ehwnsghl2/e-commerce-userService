package com.brandjunhoe.userservice.user.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import com.brandjunhoe.userservice.user.domain.nums.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cart")
@Where(clause = "deldate IS NOT NULL")
class Wish(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "usr_id", nullable = false)
    val usrId: UUID? = null,

    @Column(name = "product_code", length = 255, nullable = false)
    val productCode: String

) : DateDeleteColumnEntity()

