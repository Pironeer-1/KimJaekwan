package pironeer.week3.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pironeer.week3.global.dto.response.SuccessResponse;
import pironeer.week3.global.dto.response.result.SingleResult;
import pironeer.week3.member.dto.request.MemberRequest;
import pironeer.week3.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
@Tag(name = "멤버(member)")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<Long>> register(@Valid @RequestBody MemberRequest request) {
        SingleResult<Long> result = memberService.register(request);
        return SuccessResponse.ok(result);
    }
}
