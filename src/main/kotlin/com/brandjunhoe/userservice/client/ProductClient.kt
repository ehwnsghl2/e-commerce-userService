package com.brandjunhoe.userservice.client

import com.brandjunhoe.userservice.client.dto.ProductDTO
import com.brandjunhoe.userservice.common.response.CommonResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * Create by DJH on 2022/04/06.
 */
@FeignClient(name = "product-service")
interface ProductClient {

    @GetMapping("/api/v1/product-internal")
    fun findProductByProductcodes(@RequestParam("productCodes") productCodes: List<String>): CommonResponse<List<ProductDTO>>

}