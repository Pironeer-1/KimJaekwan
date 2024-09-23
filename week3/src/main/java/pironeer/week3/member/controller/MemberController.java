package pironeer.week3.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pironeer.week3.global.dto.response.SuccessResponse;
import pironeer.week3.global.dto.response.result.ListResult;
import pironeer.week3.global.dto.response.result.SingleResult;
import pironeer.week3.member.dto.request.MemberRequest;
import pironeer.week3.member.dto.response.MemberResponse;
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

    @GetMapping("/{memberId}")
    @Operation(summary = "회원 단건 조회")
    public SuccessResponse<SingleResult<MemberResponse>> readMember(@PathVariable("memberId") Long id) {
        SingleResult<MemberResponse> result = memberService.findMemberById(id);
        return SuccessResponse.ok(result);
    }

    @GetMapping
    @Operation(summary = "회원 목록 조회")
    public SuccessResponse<ListResult<MemberResponse>> readMembers() {
        ListResult<MemberResponse> result = memberService.findMembers();
        return SuccessResponse.ok(result);
    }

    @PutMapping("/{memberId}")
    @Operation(summary = "회원 수정")
    public SuccessResponse<SingleResult<Long>> updateMember(@PathVariable("memberId") Long id, MemberRequest request) {
        SingleResult<Long> result = memberService.updateMember(id, request);
        return SuccessResponse.ok(result);
    }

    @DeleteMapping("/{memberId}")
    @Operation(summary = "회원 삭제")
    public SuccessResponse<SingleResult<Long>> deleteMember(@PathVariable("memberId") Long id) {
        SingleResult<Long> result = memberService.delelteMember(id);
        return SuccessResponse.ok(result);
    }
}
