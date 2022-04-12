package com.brandjunhoe.userservice.cart.presentation

import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.cart.application.CartService
import com.brandjunhoe.userservice.user.presentation.dto.ReqCartSaveDTO
import com.brandjunhoe.userservice.user.presentation.dto.ReqCartUpdateDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/cart")
class CartController(private val cartService: CartService) {


    @PostMapping("/{usrId}")
    fun save(
        @PathVariable(value = "usrId") @Valid @NotBlank usrId: UUID,
        @RequestBody @Valid req: ReqCartSaveDTO
    ): CommonResponse<Unit> {
        cartService.save(usrId, req)
        return CommonResponse(HttpStatus.CREATED)
    }

    @GetMapping("/user/{usrId}")
    fun findAllByUsr(
        @PathVariable(value = "usrId") @Valid @NotBlank usrId: UUID
    ): CommonResponse<Unit> {
        cartService.findAllByUsr(usrId)
        return CommonResponse(HttpStatus.CREATED)
    }

    @PatchMapping("/{id}")
    fun updateById(
        @PathVariable(value = "id") @Valid @NotBlank id: UUID,
        @RequestBody req: ReqCartUpdateDTO
    ): CommonResponse<Unit> {
        cartService.updateById(id, req)
        return CommonResponse(HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteCart(
        @PathVariable(value = "id") @Valid @NotBlank id: UUID
    ): CommonResponse<Unit> {
        cartService.deleteById(id)
        return CommonResponse()
    }

}