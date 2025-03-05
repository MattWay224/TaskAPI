package m.api.taskapi.dto;

import lombok.Data;
import m.api.taskapi.entity.Priority;
import m.api.taskapi.entity.Status;

@Data
public class TaskDto {
	private String title;
	private String description;
	private Status status;
	private Priority priority;
	private Long assigneeId;
}
