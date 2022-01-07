package com.loan.controller

import com.loan.controller.request.CustomerRequest
import com.loan.dto.CustomerResponse
import com.loan.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/register")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid request: CustomerRequest): CustomerResponse {
        return customerService.createCustomer(request)
    }

    @GetMapping("/{id}")
    fun findClientById(@PathVariable id: Long): CustomerResponse {
        return customerService.findClientById(id)
    }
}