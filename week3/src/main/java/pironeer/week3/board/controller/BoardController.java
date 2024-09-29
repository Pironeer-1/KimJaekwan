package pironeer.week3.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pironeer.week3.board.dto.request.BoardCreateRequest;
import pironeer.week3.board.service.BoardService;
import pironeer.week3.global.dto.response.SuccessResponse;
import pironeer.week3.global.dto.response.result.SingleResult;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
@Tag(name = "Board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @Operation(summary = "Board 생성")
    public SuccessResponse<SingleResult<Long>> createBoard(@Valid @RequestBody BoardCreateRequest request) {
        SingleResult<Long> result = boardService.saveBoard(request);
        return SuccessResponse.ok(result);
    }
}
