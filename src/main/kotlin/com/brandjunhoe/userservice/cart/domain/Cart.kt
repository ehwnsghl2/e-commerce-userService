package com.brandjunhoe.userservice.cart.domain

import com.brandjunhoe.userservice.common.domain.DateDeleteColumnEntity
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cart")
class Cart(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "product_code", length = 255, nullable = false)
    val productCode: String,

    @Column(name = "item_code", length = 255, nullable = false)
    var itemCode: String,

    @Column(name = "quantity", nullable = false)
    var quantity: Int,

    @Column(name = "amount", nullable = false)
    val amount: BigDecimal

) : DateDeleteColumnEntity() {

    fun update(itemCode: String?, quantity: Int?) {
        if (itemCode != null) this.itemCode = itemCode
        if (quantity != null) this.quantity = quantity
    }

}

