package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Operation(method = "POST",
            summary = "comment 생성 API")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CommentCreateRequest request) {
        commentService.save(request);
        return ResponseEntity.ok("댓글 생성 성공!");
    }

    @Operation(method = "GET",
            summary = "comment 단건 조회 API")
    @GetMapping("/{commentId}")
    public ResponseEntity<?> read(@PathVariable("commentId") Long id) {
        CommentResponse response = commentService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(method = "GET",
            summary = "replies (대댓글) 조회 API")
    @GetMapping("/{commentId}/replies")
    public ResponseEntity<?> getReplies(@PathVariable("commentId") Long id) {
        List<CommentResponse> replies = commentService.findRepliesByParentId(id);
        return ResponseEntity.ok(replies);
    }

    @Operation(method = "DELETE",
            summary = "comment 삭제 API")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> delete(@PathVariable("commentId") Long id) {
        commentService.delete(id);
        return ResponseEntity.ok("comment 삭제 성공!");
    }

    @Operation(method = "PATCH",
            summary = "comment 수정 API")
    @PatchMapping
    public ResponseEntity<CommentResponse> update(@Valid @RequestBody CommentUpdateRequest request) {
        CommentResponse response = commentService.update(request);
        return ResponseEntity.ok().body(response);
    }
}
