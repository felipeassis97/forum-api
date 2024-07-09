package com.myproject.forum.mapper

import com.myproject.forum.dto.CreateTopicForm
import com.myproject.forum.model.Topic
import com.myproject.forum.service.CourseService
import com.myproject.forum.service.UserService
import org.springframework.stereotype.Component


@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
): Mapper<CreateTopicForm, Topic>{

    override fun map(t: CreateTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.getById(t.idCourse.toLong()),
            author = userService.getById(t.idAuthor.toLong()),
        )
    }
}