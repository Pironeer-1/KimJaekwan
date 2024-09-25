package pironeer.week3.member.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import pironeer.week3.member.entity.Member;

@Builder
public record MemberResponse(
        @NotNull
        @Schema(description = "멤버 ID", example = "1")
        Long id,
        @Schema(description = "이름", example = "닉네임")
        String username,
        String role) {

        public static MemberResponse of(Member member) {
                return MemberResponse.builder()
                        .id(member.getId())
                        .username(member.getUsername())
                        .role(member.getRole())
                        .build();
        }
}
