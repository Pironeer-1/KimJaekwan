package pironeer.week3.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pironeer.week3.global.dto.response.SuccessResponse;
import pironeer.week3.global.dto.response.result.ListResult;
import pironeer.week3.global.dto.response.result.SingleResult;
import pironeer.week3.global.exception.CustomException;
import pironeer.week3.global.exception.ErrorCode;
import pironeer.week3.global.service.ResponseService;
import pironeer.week3.member.dto.request.MemberRequest;
import pironeer.week3.member.dto.response.MemberResponse;
import pironeer.week3.member.entity.Member;
import pironeer.week3.member.mapper.MemberMapper;
import pironeer.week3.member.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public SingleResult<Long> register(MemberRequest request) {
        Member member = memberRepository.save(MemberMapper.from(request));
        return ResponseService.getSingleResult(member.getId());
    }

    public SingleResult<MemberResponse> findMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));
        MemberResponse response = MemberResponse.of(member);

        return ResponseService.getSingleResult(response);
    }

    public ListResult<MemberResponse> findMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberResponse> response = members.stream()
                .map(member -> MemberResponse.of(member))
                .collect(Collectors.toList());

        return ResponseService.getListResult(response);
    }
}
