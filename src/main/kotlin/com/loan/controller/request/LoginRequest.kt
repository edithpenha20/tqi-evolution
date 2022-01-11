package com.loan.controller.request

import com.fasterxml.jackson.annotation.JsonAlias

data class LoginRequest(
    val email: String,
    @field:JsonAlias("senha")
    val password: String
)