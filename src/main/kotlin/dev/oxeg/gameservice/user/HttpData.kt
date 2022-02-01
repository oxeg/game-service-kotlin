package dev.oxeg.gameservice.user

import java.util.*

class UserResponse(val id: UUID, val name: String)

class UserListResponse(val users: Array<UserResponse> = emptyArray())
