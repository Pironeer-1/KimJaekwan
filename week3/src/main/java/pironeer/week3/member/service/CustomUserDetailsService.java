package pironeer.week3.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pironeer.week3.global.exception.CustomException;
import pironeer.week3.global.exception.ErrorCode;
import pironeer.week3.member.dto.CustomUserDetails;
import pironeer.week3.member.entity.Member;
import pironeer.week3.member.repository.MemberRepository;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        return new CustomUserDetails(member);
    }
}
