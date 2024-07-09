package com.myproject.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class UpdateTopicForm (
    @field:NotNull
    val id: String,

    @field:NotEmpty
    val title: String,

    @field:NotEmpty
    val message: String
)
