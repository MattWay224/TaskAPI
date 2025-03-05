package m.api.taskapi.service;

import m.api.taskapi.entity.Task;
import m.api.taskapi.repo.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
	private final TaskRepository taskRepository;

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
