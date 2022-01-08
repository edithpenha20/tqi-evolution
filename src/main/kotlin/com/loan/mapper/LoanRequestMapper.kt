package com.loan.mapper

import com.loan.controller.request.LoanRequest
import com.loan.entity.Customer
import com.loan.entity.Loan
import com.loan.service.CustomerService
import org.springframework.stereotype.Component

@Component
class LoanRequestMapper(private val customerService: CustomerService): Mapper<LoanRequest, Loan> {
    override fun map(l: LoanRequest): Loan {
        return Loan(
            amount = l.amount,
            parcel = l.parcel,
            firstParcelDate = l.firstParcelDate,
            customer = customerService.findClientById(l.customerId)
        )
    }
}