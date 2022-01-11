package com.loan.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate

data class UpdateLoanRequest(
    @field:JsonAlias("valor_emprestimo")
    val amount: BigDecimal,
    @field:JsonAlias("quantidade_parcelas")
    val parcel: Int,
    @field:JsonAlias("data_primeira_parcela")
    @field:JsonFormat(pattern = "dd/MM/yyyy")
    val firstParcelDate: LocalDate
) {
}
