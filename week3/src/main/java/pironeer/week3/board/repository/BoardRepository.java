package pironeer.week3.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pironeer.week3.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
