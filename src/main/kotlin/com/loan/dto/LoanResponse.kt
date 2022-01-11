package com.loan.dto

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat
import com.loan.enums.StatusLoan
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

class LoanResponse(
    val id: Int?,
    @field:JsonAlias("codigo_emprestimo")
    val code: String?,
    val email: String?,
    @field:JsonAlias("crenda_mensal")
    val monthlyIncome: BigDecimal?,
    @field:JsonAlias("valor_emprestimo")
    val amount: BigDecimal,
    @field:JsonAlias("quantidade_parcelas")
    val parcel: Int,
    @field:JsonAlias("data_primeira_parcela")
    @JsonFormat(pattern = "dd/MM/yyyy")
    val firstParcelDate: LocalDate,
    @field:JsonAlias("data_solicitacao_emprestimo")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    val loanApplicationDate: LocalDateTime,
    var status: StatusLoan
) {
}