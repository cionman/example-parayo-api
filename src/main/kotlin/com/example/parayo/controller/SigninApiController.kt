package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.auth.SigninRequest
import com.example.parayo.domain.auth.SigninService
import com.example.parayo.domain.auth.SignupRequest
import com.example.parayo.domain.auth.SignupService
import com.example.parayo.domain.user.User
import com.google.firebase.auth.hash.Bcrypt
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SigninApiController @Autowired constructor(
    private val signinService: SigninService
){
  @PostMapping("/signin")
  fun signup(@RequestBody signinRequest: SigninRequest) =
      ApiResponse.ok(signinService.signin(signinRequest))
}
