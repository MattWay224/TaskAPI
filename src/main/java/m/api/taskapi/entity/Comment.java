package m.api.taskapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
