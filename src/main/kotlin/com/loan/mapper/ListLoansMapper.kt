package com.loan.mapper

import com.loan.dto.ListLoans
import com.loan.entity.Loan
import org.springframework.stereotype.Component

@Component
class ListLoansMapper: Mapper<Loan, ListLoans> {
    override fun map(l: Loan): ListLoans {
        return ListLoans(
            code = l.code,
            amount = l.amount,
            parcel = l.parcel,
            status = l.status!!
        )
    }
}