package com.loan.controller

import com.loan.controller.request.CustomerRequest
import com.loan.dto.CustomerResponse
import com.loan.entity.Customer
import com.loan.security.annotation.AuthorizationToAccessUserResources
import com.loan.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid request: CustomerRequest): CustomerResponse {
        return customerService.createCustomer(request)
    }

    @GetMapping("/{id}")
    @AuthorizationToAccessUserResources
    fun findClientById(@PathVariable id: Int): Customer {
        return customerService.findClientById(id)
    }
}