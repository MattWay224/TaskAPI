package m.api.taskapi.dto;

import lombok.Data;

@Data
public class CommentDto {
	private String content;
	private Long taskId;
}
