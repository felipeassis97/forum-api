package com.myproject.forum.service

import com.myproject.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course>) {

    init {
        val course1 = Course(
            id = 1,
            name = "Flutter",
            category = "Mobile"
        )

        val course2 = Course(
            id = 2,
            name = "Kotlin",
            category = "Mobile"
        )

        val course3 = Course(
            id = 3,
            name = "React",
            category = "Web"
        )

        val course4 = Course(
            id = 4,
            name = "Spring Boot",
            category = "Back End"
        )

        courses = listOf(
            course1,
            course2,
            course3,
            course4
        )
    }

    fun getById(id: Long): Course {
        return courses.stream().filter{
            c-> c.id == id
        }.findFirst().get()
    }
}
