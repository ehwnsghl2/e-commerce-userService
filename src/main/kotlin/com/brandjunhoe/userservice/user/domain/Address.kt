package com.brandjunhoe.userservice.user.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Address(

        @Column(name = "zip_code", length = 11)
        val zipCode: String,

        @Column(name = "address", length = 11)
        val address: String,

        @Column(name = "address_detail", length = 11)
        val addressDetail: String

) {

    fun getFullAddress(): String {
        return "$address $addressDetail"
    }

}
