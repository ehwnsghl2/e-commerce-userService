package com.brandjunhoe.userservice.cart.presentation

import com.brandjunhoe.userservice.cart.application.dto.CartDTO
import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.cart.application.CartService
import com.brandjunhoe.userservice.cart.presentation.dto.ReqCartSaveDTO
import com.brandjunhoe.userservice.cart.presentation.dto.ReqCartUpdateDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/v1/cart")
class CartController(private val cartService: CartService) {


    @PostMapping
    fun save(
        @RequestBody @Valid req: ReqCartSaveDTO
    ): CommonResponse<Unit> {
        cartService.save(req)
        return CommonResponse(HttpStatus.CREATED)
    }

    @GetMapping("/usr/{usrId}")
    fun findAllByUsr(
        @PathVariable(value = "usrId") @Valid @NotBlank usrId: UUID
    ): CommonResponse<List<CartDTO?>> = CommonResponse(cartService.findAllByUsr(usrId))


    @PatchMapping("/{id}")
    fun updateById(
        @PathVariable(value = "id") @Valid @NotBlank id: UUID,
        @RequestBody req: ReqCartUpdateDTO
    ): CommonResponse<Unit> {
        cartService.updateById(id, req)
        return CommonResponse()
    }

    @DeleteMapping("/{id}")
    fun deleteCart(
        @PathVariable(value = "id") @Valid @NotBlank id: UUID
    ): CommonResponse<Unit> {
        cartService.deleteById(id)
        return CommonResponse()
    }

}