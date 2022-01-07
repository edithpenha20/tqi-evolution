package com.loan.controller.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.loan.entity.Address
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class CustomerRequest(
    @field:NotEmpty(message = "The name field cannot be empty")
    val name: String,

    @field:Email
    @field:NotEmpty(message = "The e-mail field cannot be empty")
    val email: String,
    @field:NotEmpty(message = "The password field cannot be empty")
    val password: String,
    @field:JsonFormat(pattern = "dd/MM/yyyy")
    val birthDate: LocalDate,
    @field:NotEmpty(message = "The e-mail field cannot be empty")
    @field:CPF
    val cpf: String,
    val rg: String,
    val phone: String,
    val monthlyIncome: BigDecimal,
    val address: Address
) {
}