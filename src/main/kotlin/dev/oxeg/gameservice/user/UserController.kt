package dev.oxeg.gameservice.user

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Inject

@Controller("/user")
class UserController {
    @Inject
    lateinit var service: UserService

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    fun createUser(request: HttpRequest<UserCreateRequest>): HttpResponse<UserResponse> {
        val name = request.body.map { it.name }.orElseThrow { HttpStatusException(HttpStatus.BAD_REQUEST, "Name is empty") }
        return HttpResponse.ok(service.createUser(name))
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll(): HttpResponse<UserListResponse> {
        return HttpResponse.ok(service.getAllUsers())
    }
}
