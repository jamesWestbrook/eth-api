package com.greasy.api

import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.repository.Temporal
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.Date
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.TemporalType

@Entity
data class Score(
        @Id
        val id: UUID = UUID.randomUUID(),
        val score: Short,
        val initials: String,

        @CreationTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        val time: Date = Date(),
)

@RepositoryRestResource
interface ScoreRepository : CrudRepository<Score, UUID>
