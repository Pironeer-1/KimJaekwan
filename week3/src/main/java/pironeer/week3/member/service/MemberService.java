package pironeer.week3.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pironeer.week3.global.dto.response.result.SingleResult;
import pironeer.week3.global.service.ResponseService;
import pironeer.week3.member.dto.request.MemberRequest;
import pironeer.week3.member.entity.Member;
import pironeer.week3.member.mapper.MemberMapper;
import pironeer.week3.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public SingleResult<Long> register(MemberRequest request) {
        Member member = memberRepository.save(MemberMapper.from(request));
        return ResponseService.getSingleResult(member.getId());
    }
}
