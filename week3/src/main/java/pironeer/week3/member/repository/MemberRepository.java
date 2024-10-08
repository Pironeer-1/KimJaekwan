package pironeer.week3.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pironeer.week3.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);
}
