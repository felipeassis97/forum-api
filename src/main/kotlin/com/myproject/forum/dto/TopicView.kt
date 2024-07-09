import java.time.LocalDateTime
import com.myproject.forum.model.StatusTopic


data class TopicView (
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val createdAt: LocalDateTime
)
