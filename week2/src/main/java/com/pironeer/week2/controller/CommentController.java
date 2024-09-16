package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CommentRequest request) {
        try {
            commentService.save(request);
            return ResponseEntity.ok("댓글 생성 성공!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("topic이 존재하지 않음");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 생성 중 오류 발생");
        }
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<?> read(@PathVariable("commentId") Long id) {
        try {
            CommentResponse response = commentService.findById(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("topic이 존재하지 않음");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 생성 중 오류 발생");
        }
    }

    @GetMapping("/{commentId}/replies")
    public ResponseEntity<?> getReplies(@PathVariable("commentId") Long id) {
        try {
            List<CommentResponse> replies = commentService.findRepliesByParentId(id);
            return ResponseEntity.ok(replies);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("부모 comment 가 존재하지 않음");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("대댓글 조회 중 오류 발생");
        }
    }
}
