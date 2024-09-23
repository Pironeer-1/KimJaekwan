package pironeer.week3.member.mapper;

import pironeer.week3.member.dto.request.MemberRequest;
import pironeer.week3.member.entity.Member;

public class MemberMapper {
    public static Member from(MemberRequest request) {
        return Member.builder()
                .name(request.name())
                .password(request.password())
                .build();
    }
}
