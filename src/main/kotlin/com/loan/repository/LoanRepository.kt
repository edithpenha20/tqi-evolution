package com.loan.repository

import com.loan.entity.Loan
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface LoanRepository: JpaRepository<Loan, Long> {
    fun findByCode(code: String, pagination: Pageable): Page<Loan>
}
