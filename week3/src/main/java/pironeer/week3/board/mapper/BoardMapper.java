package pironeer.week3.board.mapper;

import org.springframework.stereotype.Component;
import pironeer.week3.board.dto.request.BoardCreateRequest;
import pironeer.week3.board.entity.Board;
import pironeer.week3.global.exception.CustomException;
import pironeer.week3.global.exception.ErrorCode;
import pironeer.week3.member.entity.Member;
import pironeer.week3.member.repository.MemberRepository;

import java.time.LocalDateTime;

@Component
public class BoardMapper {

    private final MemberRepository memberRepository;

    public BoardMapper(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Board from(BoardCreateRequest request) {
        Member author = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        return Board.builder()
                .title(request.title())
                .content(request.content())
                .author(author)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
