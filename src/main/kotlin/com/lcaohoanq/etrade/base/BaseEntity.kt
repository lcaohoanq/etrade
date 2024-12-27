package com.lcaohoanq.etrade.base

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
open class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID,

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime,

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime
)
