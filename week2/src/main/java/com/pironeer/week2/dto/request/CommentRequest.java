package com.pironeer.week2.dto.request;

import jakarta.validation.constraints.NotNull;

public record CommentRequest(
        @NotNull
        Long topicId,
        String content,
        Long parentComentId){
}
