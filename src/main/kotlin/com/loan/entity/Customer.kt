package com.loan.entity

import com.loan.enums.Role
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity(name = "customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null,

    @Column
    val name: String,

    @Column
    val email: String,

    @Column
    val password: String,

    @Column
    val birthDate: LocalDate,

    @Column
    val cpf: String,

    @Column
    val rg: String,

    @Column
    val phone: String,

    @Column
    val monthlyIncome: BigDecimal,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val address: Address,

    @Column
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_roles", joinColumns = [JoinColumn(name = "customer_id")])
    val roles: Set<Role> = setOf()
) {
}