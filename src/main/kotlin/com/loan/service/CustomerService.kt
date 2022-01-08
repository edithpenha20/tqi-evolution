package com.loan.service

import com.loan.controller.request.CustomerRequest
import com.loan.dto.CustomerResponse
import com.loan.entity.Customer
import com.loan.exception.ValidationException
import com.loan.mapper.CustomerRequestMapper
import com.loan.mapper.CustomerResponseMapper
import com.loan.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerRequestMapper: CustomerRequestMapper,
    private val customerResponseMapper: CustomerResponseMapper,
    private val notFoundMessage: String = "ID não encontrado."
) {

    fun createCustomer(request: CustomerRequest): CustomerResponse {
        val customerMapper = customerRequestMapper.map(request)
        customerRepository.save(customerMapper)
        return customerResponseMapper.map(customerMapper)
    }

    fun findClientById(id: Long): Customer {
        return customerRepository.findById(id)
            .orElseThrow{ ValidationException(notFoundMessage) }
//        return customerResponseMapper.map(customer)
    }

}