package pironeer.week3.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pironeer.week3.board.dto.request.BoardUpdateRequest;
import pironeer.week3.member.entity.Member;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member author;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Builder
    public Board(
            Long id,
            String title,
            String content,
            Member author,
            LocalDateTime createdDate,
            LocalDateTime updatedDate
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void update(BoardUpdateRequest request) {
        this.title = request.title();
        this.content = request.content();
        this.updatedDate = LocalDateTime.now();
    }
}
