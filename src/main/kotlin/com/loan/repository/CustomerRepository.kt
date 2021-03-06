package com.loan.repository

import com.loan.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Int> {
    fun findByEmail(email: String): Customer?
}