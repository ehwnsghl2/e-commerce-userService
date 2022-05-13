package com.brandjunhoe.userservice.wish.presentation

import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.wish.presentation.dto.ReqWishSaveDTO
import com.brandjunhoe.userservice.wish.application.WishService
import com.brandjunhoe.userservice.wish.application.dto.WishDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/v1/wish")
class WishController(private val wishService: WishService) {


    @PostMapping
    fun saveWish(@RequestBody @Valid req: ReqWishSaveDTO): CommonResponse<Unit> {
        wishService.save(req)
        return CommonResponse(HttpStatus.CREATED)
    }

    @GetMapping("/{usrId}")
    fun findAllByUsr(
        @PathVariable("usrId") @Valid @NotBlank usrId: UUID
    ): CommonResponse<List<WishDTO>> =
        CommonResponse(wishService.findAllByUsr(usrId))


    @DeleteMapping("/{id}")
    fun deleteWish(
        @PathVariable("id") @Valid @NotBlank id: UUID
    ): CommonResponse<Unit> {
        wishService.deleteById(id)
        return CommonResponse()
    }

}