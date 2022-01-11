package com.loan.controller

import com.loan.controller.request.CustomerRequest
import com.loan.dto.CustomerResponse
import com.loan.entity.Customer
import com.loan.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("admin")
class AdminController() {

    @GetMapping("/reports")
    fun report(): String {
        return "This a report. Only Admin can see it."
    }
}