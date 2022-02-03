package dev.oxeg.gameservice.user

import org.hibernate.annotations.DynamicUpdate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@DynamicUpdate
@Table(name = "user_list")
class UserEntity() {
    constructor(name: String) : this() {
        id = UUID.randomUUID()
        this.name = name
        gamesPlayed = 0
        score = 0
    }

    @Id
    @Column(name = "id", columnDefinition = "uuid-char")
    lateinit var id: UUID
        private set

    @Column(name = "name")
    lateinit var name: String
        private set

    @Column(name = "games_played")
    var gamesPlayed = 0

    @Column(name = "score")
    var score = 0

}
