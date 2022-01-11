package com.loan.service

import com.loan.exception.ValidationException
import com.loan.repository.CustomerRepository
import com.loan.security.UserCustomerDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomerService(
    private val customerRepository: CustomerRepository
): UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val customer = customerRepository.findById(id.toInt())
                .orElseThrow { ValidationException("Usuário não encongtrado.") }
        return UserCustomerDetails(customer)
    }
}