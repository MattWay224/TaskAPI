package m.api.taskapi.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "author")
	private List<Task> createdTasks;

	@OneToMany(mappedBy = "assignee")
	private List<Task> assignedTasks;
}
