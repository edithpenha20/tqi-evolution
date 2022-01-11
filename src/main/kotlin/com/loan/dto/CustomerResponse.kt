package com.loan.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.loan.entity.Address
import java.math.BigDecimal
import java.time.LocalDate

data class CustomerResponse(
    val id: Int?,
    val name: String,
    val email: String,
    val password: String,
    @field:JsonFormat(pattern = "dd/MM/yyyy")
    val birthDate: LocalDate,
    val cpf: String,
    val rg: String,
    val phone: String,
    val monthlyIncome: BigDecimal,
    val address: Address
) {

}