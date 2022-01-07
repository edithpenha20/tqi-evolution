package com.loan.repository

import com.loan.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}