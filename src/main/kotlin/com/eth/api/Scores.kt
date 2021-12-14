package com.eth.api

import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Temporal
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Component
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.TemporalType

@Entity
class Score(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,
        val score: Short,
        val initials: String,

        @CreationTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        val time: Date = Date(),
)

@RepositoryRestResource
interface ScoreRepository : CrudRepository<Score, Int> {
        fun getScoresByScoreGreaterThanOrderByScoreDesc(score: Short, page: Pageable): Page<Score>
        fun getScoresByTimeAfterOrderByScoreDesc(time: Date, page: Pageable) : Page<Score>
}
