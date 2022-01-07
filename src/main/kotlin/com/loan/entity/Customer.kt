package com.loan.entity

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "cliente")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    val name: String,
    val email: String,
    val password: String,
    val birthDate: LocalDate,
    val cpf: String,
    val rg: String,
    val phone: String,
    val monthlyIncome: BigDecimal,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val address: Address
) {
}