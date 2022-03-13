package com.brandjunhoe.userservice.auth.presentation

import com.brandjunhoe.userservice.auth.application.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AccountController(private val authService: AuthService) {


    @PostMapping("/signin")
    fun signin() {

    }

}