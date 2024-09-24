package pironeer.week3.member.mapper;

import pironeer.week3.member.dto.request.MemberRequest;
import pironeer.week3.member.entity.Member;

public class MemberMapper {
    public static Member from(MemberRequest request) {
        return Member.builder()
                .username(request.username())
                .password(request.password())
                .role("USER")
                .build();
    }
}
