package com.lcaohoanq.etrade.domain.auth

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.lcaohoanq.etrade.constant.Regex
import com.lcaohoanq.etrade.enums.Country
import com.lcaohoanq.etrade.enums.Currency
import com.lcaohoanq.etrade.enums.Gender
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

interface AuthPort {

    data class AccountRegisterDTO(
        @JsonProperty("name")
        @NotBlank(message = "Name is required") val name: String = "",

        @JsonProperty("email")
        @Email(message = "Email is invalid") val email: String = "",

        @Pattern(regexp = Regex.PHONE_NUMBER_REGEX, message = "Phone number is invalid")
        @NotBlank(message = "Phone number is required") val phoneNumber: String = "",

        val gender: Gender = Gender.OTHER,

        @Pattern(
            regexp = Regex.PASSWORD_REGEX,
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
        )
        @NotBlank(message = "Password is required") val password: String = "",

        @JsonProperty("confirm_password")
        @NotBlank(message = "Confirm password is required") val confirmPassword: String = "",

        @JsonProperty("date_of_birth")
        val dateOfBirth: String = "",

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        val preferredLanguage: Country = Country.VIETNAM,

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        val preferredCurrency: Currency = Currency.VND
    )

    data class UpdatePasswordDTO(
        @Email(message = "Email must be a valid email")
        @NotBlank(message = "Email must not be blank")
        val email: String,

        @Pattern(
            regexp = Regex.PASSWORD_REGEX,
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
        )
        @NotBlank(message = "New password must not be blank")
        val newPassword: String
    )

    data class UserLoginDTO(
        @Email(message = "Email is not valid")
        @NotBlank(message = "Email is required")
        val email: String = "",
        @NotBlank(message = "Password is required")
        val password: String = ""
    )

    data class VerifyUserDTO(
        @NotBlank(message = "Email is required") val email: String,
        @NotBlank(message = "OTP is required") val otp: String
    )

    data class ForgotPasswordResponse(val message: String)

}