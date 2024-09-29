package pironeer.week3.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateRequest(
        @NotBlank
        @Schema(description = "수정 제목", example = "수정 제목")
        String title,
        @NotNull
        @Schema(description = "수정 내용", example = "수정 내용")
        String content
) {
}
