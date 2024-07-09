package com.myproject.forum.service
import com.myproject.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(var users: List<User> = ArrayList()) {
    init {
        val user1 = User(
            id = 1,
            name = "Felipe",
            email = "felipe@email.com"
        )

        val user2 = User(
            id = 2,
            name = "Aline",
            email = "aline@email.com"
        )

        val user3 = User(
            id = 3,
            name = "Mufasinha",
            email = "mufasinha@email.com"
        )

        users = listOf(
            user1,
            user2,
            user3,
        )
    }

    fun getById(id: Long): User {
        return users.stream().filter{
                c-> c.id == id
        }.findFirst().get()
    }
}
