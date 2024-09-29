package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CommentCreateRequest(
        @NotNull
        @Schema(
                description = "Topic ID",
                example = "1",
                defaultValue = "1")
        Long topicId,
        @Schema(
                description = "댓글 내용",
                example = "내용 입니다")
        String content,
        @Schema(
                description = "부모 댓글 ID",
                example = "0",
                defaultValue = "0")
        Long parentComentId) {
}
