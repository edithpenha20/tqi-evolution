package com.loan.controller

import com.loan.controller.request.LoanRequest
import com.loan.dto.ListLoans
import com.loan.dto.LoanResponse
import com.loan.service.LoanService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/loan")
class LoanController(
    val loanService: LoanService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    @CacheEvict(value = ["loan"], allEntries = true)
    fun createLoan(@RequestBody request: LoanRequest): LoanResponse{
        return loanService.createLoan(request)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findLoanById(@PathVariable id: Long): LoanResponse{
        return loanService.findLoanById(id)
    }

    @GetMapping
    @Cacheable("loan")
    fun listLoans(
        @RequestParam(required = false) code: String?,
        @PageableDefault(size = 4, sort = ["loanApplicationDate"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<ListLoans>{
        return loanService.listLoans(code, pagination)
    }

}