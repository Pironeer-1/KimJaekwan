package pironeer.week3.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
     중복 회원 검증
     */
    private void validateDuplicateMember(MemberRequest request) {
        if (memberRepository.findByUsername(request.username()).isPresent()) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }
    }

    @Transactional
    public SingleResult<Long> register(MemberRequest request) {
        validateDuplicateMember(request);
        Member member = memberRepository.save(MemberMapper.from(request, bCryptPasswordEncoder));
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

    @Transactional
    public SingleResult<Long> updateMember(Long id, MemberRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        member.update(request);
        return ResponseService.getSingleResult(member.getId());
    }

    @Transactional
    public SingleResult<Long> delelteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        memberRepository.deleteById(id);
        return ResponseService.getSingleResult(member.getId());
    }
}
