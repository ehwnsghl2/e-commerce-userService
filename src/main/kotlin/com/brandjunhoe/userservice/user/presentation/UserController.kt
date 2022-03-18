package com.brandjunhoe.userservice.user.presentation

import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.user.application.UserService
import com.brandjunhoe.userservice.user.presentation.dto.ReqSignupDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {


    @PostMapping("/signup")
    fun signup(@RequestBody @Valid req: ReqSignupDTO): CommonResponse<Unit> {
        userService.signup(req)
        return CommonResponse(HttpStatus.CREATED)
    }

}