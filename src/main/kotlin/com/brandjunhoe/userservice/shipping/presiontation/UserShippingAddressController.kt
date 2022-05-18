package com.brandjunhoe.userservice.shipping.presiontation

import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.shipping.application.UserShippingAddressService
import com.brandjunhoe.userservice.shipping.application.dto.UserShippingAddressDTO
import com.brandjunhoe.userservice.shipping.presiontation.dto.UserShippingAddressSaveDTO
import com.brandjunhoe.userservice.shipping.presiontation.dto.UserShippingAddressUpdateDTO
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/v1/user/shipping-address")
class UserShippingAddressController(val userShippingAddressService: UserShippingAddressService) {


    @GetMapping
    fun findByAllUsr(): CommonResponse<List<UserShippingAddressDTO>> {
        val usrID = UUID.randomUUID()
        return CommonResponse(userShippingAddressService.findByAllByUsr(usrID))
    }

    @PostMapping
    fun save(@RequestBody request: UserShippingAddressSaveDTO): CommonResponse<Unit> {
        userShippingAddressService.save(request)
        return CommonResponse()
    }


    @PatchMapping("{id}")
    fun update(
        @PathVariable("id") @Valid @NotBlank id: UUID,
        @RequestBody request: UserShippingAddressUpdateDTO
    ): CommonResponse<Unit> {
        userShippingAddressService.update(id, request)
        return CommonResponse()
    }

    @PostMapping("{id}")
    fun delete(@PathVariable("id") @Valid @NotBlank id: UUID): CommonResponse<Unit> {
        userShippingAddressService.delete(id)
        return CommonResponse()
    }
}