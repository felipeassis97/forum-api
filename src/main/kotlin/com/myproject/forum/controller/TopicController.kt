package com.myproject.forum.controller
import TopicView
import com.myproject.forum.dto.CreateTopicForm
import com.myproject.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getAll(): List<TopicView> {
      return service.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicView {
        return service.getById(id)
    }

    @PostMapping()
    fun create(@RequestBody @Valid dto: CreateTopicForm) {
         service.create(dto)
    }
}