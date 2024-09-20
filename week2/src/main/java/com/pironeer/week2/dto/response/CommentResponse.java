package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record CommentResponse(Long id, Long topicId, String content, Long parentCommentId, LocalDateTime createdAt, LocalDateTime updatedAt) {

    public static CommentResponse of(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getTopicId(),
                comment.getContent(),
                comment.getParentComentId(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }

    public static List<CommentResponse> getCommentResponses(List<Comment> comments) {
        return comments.stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
    }
}
