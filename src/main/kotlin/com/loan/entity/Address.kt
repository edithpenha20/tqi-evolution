package com.loan.entity

import javax.persistence.*

@Entity
@Table(name = "endereco")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val cep: String,
    val street: String,
    val number: Long,
    val complement: String,
    val district: String,
    val city: String,
    val uf:String
) {

}