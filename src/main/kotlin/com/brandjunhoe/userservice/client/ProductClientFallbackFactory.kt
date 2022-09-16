package com.brandjunhoe.userservice.client

import com.brandjunhoe.userservice.client.dto.ProductDTO
import com.brandjunhoe.userservice.common.response.CommonResponse
import org.springframework.http.HttpStatus

/**
 * Create by DJH on 2022/09/13.
 */
class ProductClientFallbackFactory : ProductClient {
    override fun findProductByProductcodes(productCodes: List<String>): CommonResponse<List<ProductDTO>> {
        return CommonResponse(HttpStatus.NOT_FOUND)
    }
}