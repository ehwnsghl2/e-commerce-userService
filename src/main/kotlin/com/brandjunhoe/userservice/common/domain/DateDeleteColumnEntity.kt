package com.brandjunhoe.userservice.common.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Temporal
import javax.persistence.TemporalType

@MappedSuperclass
open class DateDeleteColumnEntity(

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "deldate")
        val deldate: Date? = null

) : DateColumnEntity()
