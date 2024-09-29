package pironeer.week3.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record MemberRequest(
        @NotBlank
        @Schema(description = "이름", example = "닉네임")
        String username,
        @NotBlank
        @Schema(description = "비밀번호", example = "비밀번호")
        String password) {
}
