package com.loan.mapper

import com.loan.controller.request.LoanRequest
import com.loan.dto.LoanResponse
import com.loan.entity.Customer
import com.loan.entity.Loan
import com.loan.service.CustomerService
import org.springframework.stereotype.Component

@Component
class LoanMapper: Mapper<LoanResponse, Loan> {
    override fun map(l: LoanResponse): Loan {
        return Loan(
            amount = l.amount,
            parcel = l.parcel,
            firstParcelDate = l.firstParcelDate,
            status = l.status
        )
    }
}