package dev.oxeg.gameservice.user

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Inject
import java.util.*

@Controller("/user/{id}/state")
class UserStateController {
    @Inject
    lateinit var service: UserService

    @Get
    fun getState(@PathVariable id: UUID): HttpResponse<UserStateResponse> {
        return HttpResponse.ok(service.getUserState(id))
    }
}
