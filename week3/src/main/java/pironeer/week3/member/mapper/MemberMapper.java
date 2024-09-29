package pironeer.week3.member.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pironeer.week3.member.dto.request.MemberRequest;
import pironeer.week3.member.entity.Member;

public class MemberMapper {
    public static Member from(MemberRequest request, BCryptPasswordEncoder bCryptPasswordEncoder) {
        String encodePassword = bCryptPasswordEncoder.encode(request.password());
        return Member.builder()
                .username(request.username())
                .password(encodePassword)
                .role("USER")
                .build();
    }
}
