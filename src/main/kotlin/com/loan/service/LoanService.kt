package com.loan.service

import com.loan.controller.request.LoanRequest
import com.loan.controller.request.UpdateLoanRequest
import com.loan.dto.ListLoans
import com.loan.dto.LoanResponse
import com.loan.entity.Loan
import com.loan.enums.StatusLoan
import com.loan.exception.ValidationException
import com.loan.mapper.*
import com.loan.repository.LoanRepository
import com.loan.security.UserCustomerDetails
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.temporal.ChronoUnit


@Service
class LoanService(
    private val loanRepository: LoanRepository,
    private val loanRequestMapper: LoanRequestMapper,
    private val loanResponseMapper: LoanResponseMapper,
    private val listLoansMapper: ListLoansMapper,
    private val RESPONSE_DELETE: String = "Seu empréstimo foi cancelado com sucesso.",
    private val MAXIMUM_PARCELS: Int = 60,
    private val MAXIMUM_DATE:Int = 90
) {
    @Transactional
    fun createLoan(request: LoanRequest): LoanResponse {
        validateLoanApplication(request)
        val loanMapper = loanRequestMapper.map(request)
        loanRepository.save(loanMapper)
        return loanResponseMapper.map(loanMapper)
    }

    @Transactional
    fun findLoanById(id: Int): LoanResponse {
        val loan = loanRepository.findById(id)
            .orElseThrow{ValidationException("ID não encontrado.")}
        return loanResponseMapper.map(loan)
    }

    @Transactional
    fun findById(id: Int): Loan {
        return loanRepository.findById(id)
            .orElseThrow{ValidationException("ID não encontrado.")}
    }

    @Transactional
    fun findByCode(code: String): LoanResponse {
        val loan = loanRepository.findByCode(code)
        return loanResponseMapper.map(loan)
    }

    @Transactional
    fun listLoans(pagination: Pageable): Page<ListLoans> {
        val loans = loanRepository.findAll(pagination)
        return loans.map{ l ->
            listLoansMapper.map(l)
        }
    }

    private fun validateLoanApplication(request: LoanRequest){
        if(request.parcel > MAXIMUM_PARCELS){
            throw ValidationException("O número máximo de parcelas é 60.")
        }

        val firstParcelDate: LocalDate = request.firstParcelDate
        val curranteDate = LocalDate.now()
        val range = ChronoUnit.DAYS.between(curranteDate, firstParcelDate)

        if (range > MAXIMUM_DATE) {
            throw ValidationException("A data limite para pagamento da primeira parcela é: " + curranteDate.plusDays(90))
        }
    }

    @Transactional
    fun deleteLoanById(id: Int) {
        val loan = findById(id)
        loan.status = StatusLoan.CANCEL
        loanRepository.save(loan)
        RESPONSE_DELETE
    }

    fun updateLoanById(id: Int, loanUpdated: UpdateLoanRequest) {
        var loan = findById(id)
        if (loan.status != StatusLoan.CANCEL){
            loan.amount = loanUpdated.amount
            loan.parcel = loanUpdated.parcel
            loan.firstParcelDate = loanUpdated.firstParcelDate
            loanRepository.save(loan)
        } else {
            throw ValidationException("Empréstimo foi cancelado pelo cliente, faça uma nova solicitação.")
        }

    }

}
