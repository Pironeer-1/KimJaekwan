package pironeer.week3.member.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record MemberResponse(
        @NotNull
        @Schema(description = "멤버 ID", example = "1")
        Long id,
        @Schema(description = "이름", example = "닉네임")
        String name) {
}
