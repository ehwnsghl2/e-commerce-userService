package com.brandjunhoe.userservice.user.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Address(

    @Column(name = "zip_code", length = 6, nullable = false)
    val zipCode: String,

    @Column(name = "address", length = 255, nullable = false)
    val address: String,

    @Column(name = "address_detail", length = 255)
    val addressDetail: String

) {

    //
    fun getFullAddress(): String {
        return "$address $addressDetail"
    }

}
