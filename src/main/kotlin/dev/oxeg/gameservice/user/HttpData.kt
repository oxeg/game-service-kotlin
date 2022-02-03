@file:Suppress("unused")

package dev.oxeg.gameservice.user

import java.util.*

class UserResponse(val id: UUID, val name: String)

class UserListResponse(val users: List<UserResponse> = emptyList())

class UserStateResponse(val gamesPlayed: Int, val score: Int)

class UserCreateRequest(val name: String)
