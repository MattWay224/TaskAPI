package m.api.taskapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	private Priority priority;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;

	@ManyToOne
	@JoinColumn(name = "assignee_id")
	private User assignee;

	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Comment> comments;
}
