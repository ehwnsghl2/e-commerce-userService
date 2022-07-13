package com.brandjunhoe.userservice.user.presentation

import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.user.application.UserService
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.presentation.dto.ReqSignupDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/v1/user")
class UserController(private val userService: UserService) {


    @PostMapping("/signup")
    fun signup(@RequestBody @Valid req: ReqSignupDTO): CommonResponse<Unit> {
        userService.signup(req)
        return CommonResponse(HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") @Valid @NotBlank id: UUID): CommonResponse<String?> {
        return CommonResponse(userService.findById(id))
    }

}