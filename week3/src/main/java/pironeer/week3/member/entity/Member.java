package pironeer.week3.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pironeer.week3.member.dto.request.MemberRequest;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String password;

    @Builder
    public Member(
            Long id,
            String name,
            String password
    ) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void update(MemberRequest request) {
        this.name = request.name();
        this.password = request.password();
    }
}
