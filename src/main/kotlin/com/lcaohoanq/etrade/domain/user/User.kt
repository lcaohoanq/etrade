package com.lcaohoanq.etrade.domain.user

import com.fasterxml.jackson.annotation.*
import com.lcaohoanq.etrade.base.entity.BaseEntity
import com.lcaohoanq.etrade.domain.avatar.Avatar
import com.lcaohoanq.etrade.domain.wallet.Wallet
import com.lcaohoanq.etrade.enums.Gender
import com.lcaohoanq.etrade.enums.UserRole
import com.lcaohoanq.etrade.enums.UserStatus
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import org.hibernate.envers.Audited
import java.time.LocalDateTime

@Audited
@Entity
@Table(name = "users")
data class User(
    @Column(name = "email", nullable = false, length = 100)
    @Email
    var email: String? = null,

    @Column(name = "password", nullable = false, length = 200)
    @JsonProperty("password")
    var hashedPassword: String? = null,

    var name: String? = null,

    @Enumerated(EnumType.STRING)
    var gender: Gender? = null,

    @Column(name = "is_active", columnDefinition = "boolean default true")
    @JsonProperty("is_active")
    var isActive: Boolean = true,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: UserStatus = UserStatus.UNVERIFIED,

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "activity_status")
    var activityStatus: ActivityStatus = ActivityStatus.OFFLINE,

    @Column(name = "date_of_birth")
    var dateOfBirth: String? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
    var avatars: List<Avatar> = mutableListOf(),

    @Column(name = "phone_number", nullable = false, length = 100)
    @JsonProperty("phone_number")
    var phoneNumber: String? = null,

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    @JsonManagedReference //to prevent infinite loop
    @JsonIgnore
    var wallet: Wallet? = null,

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role")
    var role: UserRole = UserRole.MEMBER,

    @Column(name = "preferred_language")
    var preferredLanguage: String? = null,

    @Column(name = "preferred_currency")
    var preferredCurrency: String? = null,

    @Column(name = "last_login_timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    var lastLoginTimestamp: LocalDateTime? = null,
) : BaseEntity() {

    enum class ActivityStatus {
        ONLINE, OFFLINE
    }
}