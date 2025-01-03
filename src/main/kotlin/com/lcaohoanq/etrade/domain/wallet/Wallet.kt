package com.lcaohoanq.etrade.domain.wallet

import com.fasterxml.jackson.annotation.JsonBackReference
import com.lcaohoanq.etrade.base.entity.BaseEntity
import com.lcaohoanq.etrade.domain.user.User
import jakarta.persistence.*
import org.hibernate.envers.Audited

@Audited
@Entity
@Table(name = "wallets")
data class Wallet(
    @Column(name = "balance", nullable = false)
    var balance: Float = 0f,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference // Prevent infinite loop when serializing
    var user: User? = null
) : BaseEntity()
