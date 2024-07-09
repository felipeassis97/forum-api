package com.myproject.forum.service
import TopicView
import com.myproject.forum.dto.CreateTopicForm
import com.myproject.forum.dto.UpdateTopicForm
import com.myproject.forum.exceptions.NotFoundException
import com.myproject.forum.mapper.TopicFormMapper
import com.myproject.forum.mapper.TopicViewMapper
import com.myproject.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.stream.Collectors

@Service
class TopicService(private var topics: List<Topic> = ArrayList(),
                   private val topicViewMapper: TopicViewMapper,
                   private val topicFormMapper: TopicFormMapper) {

    fun getAll(): List<TopicView> {
       return topics.stream().map {
           t -> topicViewMapper.map(t)
       }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicView {
        val topic =  topics.stream().filter {
            t -> t.id == id
        }.findFirst().orElseThrow{
            NotFoundException("Topic not found!")
        }
        return topicViewMapper.map(topic)
    }

    fun create(dto: CreateTopicForm): TopicView {
        val topic = topicFormMapper.map(dto)
        topic.id = topics.size.toLong() + 1
        topics =  topics.plus(topic)

        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm) {

    }

    fun delete(id: Long) {

    }
}