package dev.oxeg.gameservice.user

import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Inject
import java.util.*

class UserService {
    @Inject
    lateinit var repository: UserRepository

    fun createUser(name: String): UserResponse {
        val entity = repository.create(name)
        return entity.toUserResponse()
    }

    fun getUserState(userId: UUID): UserStateResponse {
        return repository.getById(userId)?.toUserStateResponse() ?: throw HttpStatusException(HttpStatus.NOT_FOUND, "User not found")
    }

    fun getAllUsers():UserListResponse{
        val userList = repository.getAll()
            .map { it.toUserResponse() }
            .toList()
        return UserListResponse(userList)
    }

    private fun UserEntity.toUserResponse(): UserResponse = UserResponse(this.id, this.name)

    private fun UserEntity.toUserStateResponse(): UserStateResponse = UserStateResponse(this.gamesPlayed, this.score)
}
