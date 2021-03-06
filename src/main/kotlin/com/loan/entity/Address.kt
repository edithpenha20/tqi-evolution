package com.loan.entity

import com.fasterxml.jackson.annotation.JsonAlias
import javax.persistence.*

@Entity(name = "address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val cep: String,
    @field:JsonAlias("rua")
    val street: String,
    @field:JsonAlias("numero")
    val number: Long,
    @field:JsonAlias("complemento")
    val complement: String,
    @field:JsonAlias("bairro")
    val district: String,
    @field:JsonAlias("cidade")
    val city: String,
    val uf:String
) {

}