package com.lcaohoanq.etrade.domain.user

import com.lcaohoanq.etrade.api.PageResponse
import com.lcaohoanq.etrade.domain.auth.AuthPort
import com.lcaohoanq.etrade.repository.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) : IUserService{
    override fun fetchUser(pageable: Pageable): PageResponse<User> {
        TODO("Not yet implemented")
    }

    override fun loginOrRegisterGoogle(
        email: String,
        name: String,
        googleId: String,
        avatarUrl: String
    ): String {
        TODO("Not yet implemented")
    }

    override fun findUserById(id: UUID): User {
        TODO("Not yet implemented")
    }

    override fun findUserByEmail(email: String): User {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(): List<User> = userRepository.findAll()

    override fun findByUsername(username: String): User {
        TODO("Not yet implemented")
    }

    override fun findAll(keyword: String, pageable: Pageable): Page<User>? {
        TODO("Not yet implemented")
    }

    override fun blockOrEnable(userId: UUID, active: Boolean) {
        TODO("Not yet implemented")
    }

    override fun updateUser(userId: UUID, updatedUserDTO: User): User {
        TODO("Not yet implemented")
    }

    override fun bannedUser(userId: UUID) {
        TODO("Not yet implemented")
    }

    override fun updatePassword(updatePasswordDTO: AuthPort.UpdatePasswordDTO) {
        TODO("Not yet implemented")
    }

    override fun softDeleteUser(userId: UUID) {
        TODO("Not yet implemented")
    }

    override fun restoreUser(userId: UUID) {
        TODO("Not yet implemented")
    }

    override fun validateAccountBalance(user: User, basePrice: Long) {
        TODO("Not yet implemented")
    }

    override fun existsByEmail(email: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun existsByPhoneNumber(phoneNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun existsById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun saveUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun disconnect(user: User) {
        TODO("Not yet implemented")
    }

    override fun findConnectedUsers(): List<User> {
        TODO("Not yet implemented")
    }
}