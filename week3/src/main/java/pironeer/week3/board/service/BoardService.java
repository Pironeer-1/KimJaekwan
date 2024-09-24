package pironeer.week3.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pironeer.week3.board.dto.request.BoardCreateRequest;
import pironeer.week3.board.entity.Board;
import pironeer.week3.board.mapper.BoardMapper;
import pironeer.week3.board.repository.BoardRepository;
import pironeer.week3.global.dto.response.result.SingleResult;
import pironeer.week3.global.service.ResponseService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Transactional
    public SingleResult<Long> saveBoard(BoardCreateRequest request) {
        Board board = boardRepository.save(boardMapper.from(request));
        return ResponseService.getSingleResult(board.getId());
    }
}
