package com.brandjunhoe.userservice.user.domain

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(name = "name", length = 20, nullable = false)
        val name: String
)