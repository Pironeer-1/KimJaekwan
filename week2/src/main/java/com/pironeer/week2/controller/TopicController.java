package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.TopicRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.service.CommentService;
import com.pironeer.week2.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topic")
public class TopicController {

    private final TopicService topicService;

    @Operation(method = "POST",
            summary = "topic 생성 API")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @Operation(method = "GET",
            summary = "topic 단건 조회 API")
    @GetMapping("/{topicId}")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id) {
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(method = "GET",
            summary = "topic 목록 조회 API")
    @GetMapping
    public ResponseEntity<List<TopicResponse>> readAllTopic() {
        List<TopicResponse> response = topicService.findAll();
        return ResponseEntity.ok(response);
    }

    @Operation(method = "GET",
            summary = "topic 으로 comment 조회 API")
    @GetMapping("/{topicId}/comments")
    public ResponseEntity<List<CommentResponse>> readCommentsOnTopic(@PathVariable("topicId") Long id) {
        List<CommentResponse> response = topicService.findByTopic(id);
        return ResponseEntity.ok(response);
    }

    @Operation(method = "DELETE",
            summary = "topic 삭제 API")
    @DeleteMapping("/{topicId}")
    public ResponseEntity<?> delete(@PathVariable("topicId") Long id) {
        topicService.delete(id);
        return ResponseEntity.ok("topic 삭제 성공!");
    }

    @Operation(method = "PATCH",
            summary = "topic 수정 API")
    @PatchMapping("/{topicId}")
    public ResponseEntity<?> update(@PathVariable("topicId") Long id, @RequestBody TopicRequest request) {
        try{
            topicService.update(id, request);
            return ResponseEntity.ok("topic 수정 완료!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("해당 ID의 topic이 존재하지 않음");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("topic 수정 중 오류 발생");
        }
    }
}
