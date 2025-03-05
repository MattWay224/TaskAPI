package m.api.taskapi.service;


import m.api.taskapi.entity.Comment;
import m.api.taskapi.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;

	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public List<Comment> getCommentsByTaskId(Long taskId) {
		return commentRepository.findByTaskId(taskId);
	}
}
