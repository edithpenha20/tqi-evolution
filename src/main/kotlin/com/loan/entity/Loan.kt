package com.loan.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var code: String? = "TQI" + (Math.random() * 1000).toInt(),
    val amount: BigDecimal,
    val parcel: Int,
    val firstParcelDate: LocalDate,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    var loanApplicationDate: LocalDateTime  = LocalDateTime.now(),
    @Enumerated(EnumType.STRING)
    var status: StatusLoan = StatusLoan.SENT,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: Customer? = null
) {
}
