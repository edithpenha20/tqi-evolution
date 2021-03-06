package com.loan.mapper

import com.loan.controller.request.LoanRequest
import com.loan.entity.Customer
import com.loan.entity.Loan
import com.loan.enums.StatusLoan
import com.loan.service.CustomerService
import org.springframework.stereotype.Component

@Component
class LoanRequestMapper(private val customerService: CustomerService): Mapper<LoanRequest, Loan> {
    override fun map(l: LoanRequest): Loan {
        return Loan(
            code = "TQI" + (Math.random() * 1000).toInt(),
            amount = l.amount,
            parcel = l.parcel,
            firstParcelDate = l.firstParcelDate,
            customer = customerService.findClientById(l.customerId),
            status = StatusLoan.SENT,
        )
    }
}