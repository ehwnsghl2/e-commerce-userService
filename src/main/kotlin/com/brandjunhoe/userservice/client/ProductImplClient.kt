package com.brandjunhoe.userservice.client

import com.brandjunhoe.userservice.client.dto.ProductDTO
import org.springframework.stereotype.Component

/**
 * Create by DJH on 2022/04/06.
 */
@Component
class ProductImplClient(private val productClient: ProductClient) {

    fun findProductByProductcodes(orderProductCodes: List<String>): List<ProductDTO> =
        productClient.findProductByProductcodes(orderProductCodes).data!!


}