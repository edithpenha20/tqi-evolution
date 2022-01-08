package com.loan.mapper

import com.loan.dto.LoanResponse
import com.loan.entity.Loan
import org.springframework.stereotype.Component

@Component
class LoanResponseMapper: Mapper<Loan, LoanResponse> {
    override fun map(l: Loan): LoanResponse {
        return LoanResponse(
            id = l.id,
            code = l.code,
            email = l.customer?.email,
            monthlyIncome = l.customer?.monthlyIncome,
            amount = l.amount,
            parcel = l.parcel,
            firstParcelDate = l.firstParcelDate,
            loanApplicationDate = l.loanApplicationDate,
            status = l.status
        )
    }
}