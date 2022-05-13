package com.brandjunhoe.userservice.cart.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cart")
@Where(clause = "deldate IS NULL")
class Cart(

    @Column(name = "usr_id", nullable = false)
    val usrId: UUID,

    @Column(name = "product_code", length = 255, nullable = false)
    val productCode: String,

    @Column(name = "item_code", length = 255, nullable = false)
    var itemCode: String,

    quantity: Int,

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID? = null

) : DateDeleteColumnEntity() {

    @Column(name = "quantity", nullable = false)
    final var quantity: Int = quantity
        private set

    fun changeQuantity(quantity: Int) {
        this.quantity = quantity
    }

    fun addQuantity() {
        this.quantity.plus(1)
    }

}

