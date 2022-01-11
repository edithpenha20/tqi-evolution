package com.loan.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.loan.enums.StatusLoan
import java.math.BigDecimal

data class ListLoans(
    @field:JsonAlias("codigo_emprestimo")
    val code: String?,
    @field:JsonAlias("valor_emprestimo")
    val amount: BigDecimal,
    @field:JsonAlias("quantidade_parcelas")
    val parcel: Int,
    val status: StatusLoan
) {

}
