package com.loan.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.loan.enums.StatusLoan
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "loan")
data class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var code: String? = null,
    var amount: BigDecimal,
    var parcel: Int,
    var firstParcelDate: LocalDate,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    var loanApplicationDate: LocalDateTime  = LocalDateTime.now(),
    @Enumerated(EnumType.STRING)
    var status: StatusLoan?,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: Customer? = null
) {
}
