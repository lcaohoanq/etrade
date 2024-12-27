package com.lcaohoanq.etrade.domain.socialaccount

import com.lcaohoanq.etrade.base.entity.BaseEntity
import com.lcaohoanq.etrade.domain.user.User
import com.lcaohoanq.etrade.enums.ProviderName
import jakarta.persistence.*


@Entity
@Table(name = "social_accounts")
class SocialAccount : BaseEntity() {
    @Column(name = "email", length = 150)
    private var email: String? = null

    @Column(name = "name")
    private var name: String? = null

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "provider_name")
    private var providerName: ProviderName? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private val user: User? = null
}