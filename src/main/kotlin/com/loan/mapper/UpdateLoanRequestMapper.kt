package com.loan.mapper

import com.loan.controller.request.LoanRequest
import com.loan.controller.request.UpdateLoanRequest
import com.loan.entity.Customer
import com.loan.entity.Loan
import com.loan.enums.StatusLoan
import com.loan.service.CustomerService
import org.springframework.stereotype.Component

@Component
class UpdateLoanRequestMapper(private val customerService: CustomerService): Mapper<UpdateLoanRequest, Loan> {
    override fun map(l: UpdateLoanRequest): Loan {
        return Loan(
            amount = l.amount,
            parcel = l.parcel,
            firstParcelDate = l.firstParcelDate,
            status = StatusLoan.SENT,
        )
    }
}