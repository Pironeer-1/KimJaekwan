package pironeer.week3.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardCreateRequest(
        @NotBlank
        @Schema(description = "제목", example = "제목")
        String title,
        @NotNull
        @Schema(description = "내용", example = "내용")
        String content,
        @NotNull
        @Schema(description = "글쓴이", example = "1")
        Long memberId
) {
}
