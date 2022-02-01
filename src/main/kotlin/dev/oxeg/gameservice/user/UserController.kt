package dev.oxeg.gameservice.user

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import java.util.*

@Controller("/user")
class UserController {
    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll(): HttpResponse<UserListResponse> {
        val users = arrayOf(
            UserResponse(UUID.randomUUID(), "Luke"),
            UserResponse(UUID.randomUUID(), "Han"),
            UserResponse(UUID.randomUUID(), "Chewie"),
        )
        return HttpResponse.ok(UserListResponse(users))
    }
}
