package com.brandjunhoe.userservice.wish.presentation

import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.wish.application.WishService
import com.brandjunhoe.userservice.user.presentation.dto.ReqWishSaveDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/wish")
class WishController(private val wishService: WishService) {


    @PostMapping("/{usrId}")
    fun save(
        @PathVariable(value = "usrId") @Valid @NotBlank usrId: UUID,
        @RequestBody @Valid req: ReqWishSaveDTO
    ): CommonResponse<Unit> {
        wishService.save(usrId, req)
        return CommonResponse(HttpStatus.CREATED)
    }

    @GetMapping("/{usrId}")
    fun findAllByUsr(
        @PathVariable(value = "usrId") @Valid @NotBlank usrId: UUID
    ): CommonResponse<Unit> {
        wishService.findAllByUsr(usrId)
        return CommonResponse(HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun deleteWish(
        @PathVariable(value = "id") @Valid @NotBlank id: UUID
    ): CommonResponse<Unit> {
        wishService.deleteById(id)
        return CommonResponse()
    }

    @GetMapping("/test")
    fun test(){
        wishService.test()
    }

}