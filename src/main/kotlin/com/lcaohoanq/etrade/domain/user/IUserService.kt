package com.lcaohoanq.etrade.domain.user

import com.lcaohoanq.etrade.api.PageResponse
import com.lcaohoanq.etrade.base.exception.DataNotFoundException
import com.lcaohoanq.etrade.domain.auth.AuthPort.UpdatePasswordDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface IUserService {
    fun fetchUser(pageable: Pageable): PageResponse<User>

    @Throws(Exception::class)
    fun loginOrRegisterGoogle(
        email: String,
        name: String,
        googleId: String,
        avatarUrl: String
    ): String

    @Throws(DataNotFoundException::class)
    fun findUserById(id: UUID): User

    @Throws(DataNotFoundException::class)
    fun findUserByEmail(email: String): User

    fun getAllUsers(): List<User>

    @Throws(DataNotFoundException::class)
    fun findByUsername(username: String): User

    @Throws(Exception::class)
    fun findAll(keyword: String, pageable: Pageable): Page<User>?

    @Throws(DataNotFoundException::class)
    fun blockOrEnable(userId: UUID, active: Boolean)

    @Transactional
    @Throws(Exception::class)
    fun updateUser(userId: UUID, updatedUserDTO: User): User

    @Throws(DataNotFoundException::class)
    fun bannedUser(userId: UUID)

    @Throws(Exception::class)
    fun updatePassword(updatePasswordDTO: UpdatePasswordDTO)

    @Throws(DataNotFoundException::class)
    fun softDeleteUser(userId: UUID)

    @Throws(DataNotFoundException::class)
    fun restoreUser(userId: UUID)

    fun validateAccountBalance(user: User, basePrice: Long)

    fun existsByEmail(email: String): Boolean

    fun existsByPhoneNumber(phoneNumber: String): Boolean

    fun existsById(id: UUID): Boolean

    fun saveUser(user: User)
    fun disconnect(user: User)
    fun findConnectedUsers(): List<User>
}
