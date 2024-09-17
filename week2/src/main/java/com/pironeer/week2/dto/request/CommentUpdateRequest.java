package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CommentUpdateRequest(
        Long id,
        @Schema(
                description = "댓글 내용",
                example = "내용 입니다")
        String content) {
}
