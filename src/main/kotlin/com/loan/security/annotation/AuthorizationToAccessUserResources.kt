package com.loan.security.annotation

import org.springframework.security.access.prepost.PreAuthorize

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@PreAuthorize("hasRole('ROLE_ADMIN') or #id == authentication.principal.id")
annotation class AuthorizationToAccessUserResources
