package com.lcaohoanq.etrade.domain.auth

import com.lcaohoanq.etrade.base.exception.DataNotFoundException
import com.lcaohoanq.etrade.constant.Regex
import com.lcaohoanq.etrade.domain.avatar.Avatar
import com.lcaohoanq.etrade.domain.user.User
import com.lcaohoanq.etrade.domain.user.UserMapper
import com.lcaohoanq.etrade.domain.user.UserPort
import com.lcaohoanq.etrade.domain.user.UserRepository
import com.lcaohoanq.etrade.domain.wallet.Wallet
import com.lcaohoanq.etrade.domain.wallet.WalletRepository
import com.lcaohoanq.etrade.enums.Country
import com.lcaohoanq.etrade.enums.Currency
import com.lcaohoanq.etrade.exception.MalformBehaviourException
import com.lcaohoanq.etrade.exception.PasswordWrongFormatException
import com.lcaohoanq.etrade.metadata.MediaMeta
import jakarta.servlet.http.HttpServletRequest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val walletRepository: WalletRepository,
    private val userMapper: UserMapper
) : IAuthService {
    override fun register(accountRegisterDTO: AuthPort.AccountRegisterDTO): User {
        if (!accountRegisterDTO.password.matches(Regex.PASSWORD_REGEX.toRegex())) {
            throw PasswordWrongFormatException(
                "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
            )
        }

        if (accountRegisterDTO.password != accountRegisterDTO.confirmPassword) {
            throw MalformBehaviourException("Password and confirm password must be the same")
        }

        var email = accountRegisterDTO.email
        if (userRepository.existsByEmail(email)) {
            throw DataIntegrityViolationException(
                "Email already exists"
            )
        }

        if (userRepository.existsByPhoneNumber(accountRegisterDTO.phoneNumber)) {
            throw DataIntegrityViolationException("Phone number already exists")
        }

        val request: HttpServletRequest =
            (RequestContextHolder.getRequestAttributes() as? ServletRequestAttributes)
                ?.request ?: throw NullPointerException("RequestAttributes are null")

        val acceptLanguage = request.getHeader("Accept-Language")

        var preferredLanguage = accountRegisterDTO.preferredLanguage
            ?: if (acceptLanguage.isNullOrEmpty()) Country.UNITED_STATES
            else Country.valueOf(acceptLanguage.uppercase())

        var preferredCurrency = accountRegisterDTO.preferredCurrency ?: Currency.USD
        var newUser = User().apply {
            name = accountRegisterDTO.name
            email = accountRegisterDTO.email
            hashedPassword = accountRegisterDTO.password
            phoneNumber = accountRegisterDTO.phoneNumber
            gender = accountRegisterDTO.gender
            dateOfBirth = accountRegisterDTO.dateOfBirth
        }

        val avatar = Avatar().apply {
            mediaMeta = MediaMeta()
            user = newUser
        }

        // 4. Add avatar to user's avatar list
        newUser.avatars = listOf(avatar)

        // 5. Create and save the wallet
        val newWallet = Wallet(user = newUser).let { walletRepository.save(it) }
        // 5.1 Set the wallet balance to 0

        newUser.wallet = newWallet

        // 6. Save everything
        return userRepository.save(newUser)
    }

    override fun login(userLoginDTO: AuthPort.UserLoginDTO): AuthPort.LoginResponse {
        val user = userRepository.findByEmail(userLoginDTO.email)
            ?.orElseThrow(({ DataNotFoundException("User not found") }))

        if (user?.hashedPassword != userLoginDTO.password) {
            throw DataNotFoundException("Password is incorrect")
        }

        return AuthPort.LoginResponse(
            user = userMapper.toUserResponse(user),
        )
    }

    override fun getUserDetailsFromToken(token: String): UserPort.UserResponse {
        TODO("Not yet implemented")
    }

    override fun logout(token: String, user: User) {
        TODO("Not yet implemented")
    }

    override fun verifyOtpToVerifyUser(userId: UUID, otp: String) {
        TODO("Not yet implemented")
    }

    override fun verifyOtpIsCorrect(userId: UUID, otp: String) {
        TODO("Not yet implemented")
    }
}