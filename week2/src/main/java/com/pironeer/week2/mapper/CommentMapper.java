package com.pironeer.week2.mapper;

import com.pironeer.week2.dto.request.CommentRequest;
import com.pironeer.week2.repository.domain.Comment;

import java.time.LocalDateTime;

public class CommentMapper {
    public static Comment from(CommentRequest request) {
        return Comment.builder()
                .topicId(request.topicId())
                .content(request.content())
                .parentComentId(request.parentComentId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
