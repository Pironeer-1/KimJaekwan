package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CommentCreateRequest(
        @NotNull
        Long topicId,
        @Schema(
                description = "댓글 내용",
                example = "수정할 내용 입니다")
        String content,
        Long parentComentId) {
}
