package com.pironeer.week2.repository.domain;

import com.pironeer.week2.dto.request.CommentUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private Long topicId;
    private String content;
    private Long parentComentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Comment(Long id, Long topicId, String content, Long parentComentId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.topicId = topicId;
        this.content = content;
        this.parentComentId = parentComentId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Comment update(CommentUpdateRequest request) {
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}
