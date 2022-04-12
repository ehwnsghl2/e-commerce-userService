package com.brandjunhoe.userservice.wish.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Where
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

    @Column(name = "product_code", length = 255, nullable = false)
    val productCode: String

) : DateDeleteColumnEntity()

