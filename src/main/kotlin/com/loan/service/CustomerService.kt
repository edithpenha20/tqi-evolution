package com.loan.service

import com.loan.controller.request.CustomerRequest
import com.loan.dto.CustomerResponse
import com.loan.entity.Customer
import com.loan.enums.Role
import com.loan.exception.ValidationException
import com.loan.mapper.CustomerRequestMapper
import com.loan.mapper.CustomerResponseMapper
import com.loan.repository.CustomerRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerRequestMapper: CustomerRequestMapper,
    private val customerResponseMapper: CustomerResponseMapper,
    private val bCrypt: BCryptPasswordEncoder
) {

    fun createCustomer(request: CustomerRequest): CustomerResponse {
        val customerMapper = customerRequestMapper.map(request)
        val customer = customerMapper.copy(
            roles = setOf(Role.CUSTOMER),
            password = bCrypt.encode(request.password)
        )
        customerRepository.save(customer)
        return customerResponseMapper.map(customerMapper)
    }

    fun findClientById(id: Int): Customer {
        return customerRepository.findById(id)
            .orElseThrow{ ValidationException("ID não encontrado.") }
//        return customerResponseMapper.map(customer)
    }

}