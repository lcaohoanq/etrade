package com.lcaohoanq.etrade.repository

import com.lcaohoanq.etrade.domain.user.User
import com.lcaohoanq.etrade.enums.UserRole
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {

    fun findByEmail(email: String): Optional<User>

    fun existsByEmail(email: String): Boolean

    fun existsByPhoneNumber(phoneNumber: String): Boolean

    fun findByPhoneNumber(phoneNumber: String): Optional<User>

    fun findByRole(role: UserRole): Optional<User>

    fun findAllByActivityStatus(status: User.ActivityStatus): List<User>

    @Query("SELECT u FROM User u WHERE u.role = :role")
    fun findAllUserWithRole(pageable: Pageable, role: UserRole): Page<User>

    @Modifying
    @Query("UPDATE User u SET u.isActive = false WHERE u.id = :id")
    fun softDeleteUser(id: UUID)

    @Modifying
    @Query("UPDATE User u SET u.isActive = true WHERE u.id = :id")
    fun restoreUser(id: UUID)
}

