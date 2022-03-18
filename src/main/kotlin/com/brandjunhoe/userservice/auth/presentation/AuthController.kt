package com.brandjunhoe.userservice.auth.presentation

import com.brandjunhoe.userservice.auth.application.AuthService
import com.brandjunhoe.userservice.auth.application.dto.UserInfoDTO
import com.brandjunhoe.userservice.auth.presentation.dto.ReqSigninDTO
import com.brandjunhoe.userservice.common.response.CommonResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {


    @PostMapping("/signin")
    fun signin(@RequestBody @Valid request: ReqSigninDTO): CommonResponse<UserInfoDTO> =
        CommonResponse(authService.signin(request))


}