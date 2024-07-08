package com.myproject.forum.model
import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val answers: List<Answer> = ArrayList()
)
