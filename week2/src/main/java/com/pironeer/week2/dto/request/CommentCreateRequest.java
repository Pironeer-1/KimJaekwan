package com.pironeer.week2.dto.request;

import jakarta.validation.constraints.NotNull;

public record CommentCreateRequest(
        @NotNull
        Long topicId,
        String content,
        Long parentComentId){
}
