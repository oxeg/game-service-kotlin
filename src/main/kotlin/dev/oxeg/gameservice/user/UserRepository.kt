package dev.oxeg.gameservice.user

import io.micronaut.transaction.annotation.ReadOnly
import jakarta.inject.Singleton
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional


@Singleton
open class UserRepository {
    @PersistenceContext
    lateinit var entityManager: EntityManager

    @Transactional
    open fun create(name: String): UserEntity {
        val entity = UserEntity(name)
        entityManager.persist(entity)
        return entity
    }

    @ReadOnly
    open fun getById(userId: UUID): UserEntity? {
        return entityManager.find(UserEntity::class.java, userId)
    }

    @ReadOnly
    open fun getAll(): List<UserEntity> {
        val query = entityManager.createQuery(
            """
            SELECT u
            FROM UserEntity u
        """.trimIndent(), UserEntity::class.java
        )
        return query.resultList
    }
}
