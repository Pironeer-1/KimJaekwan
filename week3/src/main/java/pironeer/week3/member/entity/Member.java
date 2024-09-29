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

    private String username;
    private String password;
    private String role;

    @Builder
    public Member(
            Long id,
            String username,
            String password,
            String role
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void update(MemberRequest request) {
        this.username = request.username();
        this.password = request.password();
    }
}
