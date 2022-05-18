package com.brandjunhoe.userservice.common.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Temporal
import javax.persistence.TemporalType

@MappedSuperclass
class DateDeleteColumnEntity(

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deldate")
    var deldate: Date? = null

) : DateColumnEntity() {

    fun delete() {
        this.deldate = Date()
    }

}

