package m.api.taskapi.repo;

import m.api.taskapi.entity.Task;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByAssigneeId(Long assigneeId);

	List<Task> findByAuthorId(Long authorId);

	@NotNull
	Optional<Task> findById(@NotNull Long id);

	Optional<Task> findByTitle(String title);
}
