package pironeer.week3.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pironeer.week3.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
