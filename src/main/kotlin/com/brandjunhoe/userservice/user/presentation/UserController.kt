package com.brandjunhoe.userservice.user.presentation

import com.brandjunhoe.userservice.user.application.UserService
import com.brandjunhoe.userservice.user.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {


    @GetMapping("/")
    fun get(): List<User> = userService.get()

}