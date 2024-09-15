package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.TopicRequest;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.service.TopicService;
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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id) {
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponse>> readAllTopic() {
        List<TopicResponse> response = topicService.findAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{topicId}")
    public ResponseEntity<?> delete(@PathVariable("topicId") Long id) {
        topicService.delete(id);
        return ResponseEntity.ok("topic 삭제 성공!");
    }

    @PatchMapping("/{topicId}")
    public ResponseEntity<?> update(@PathVariable("topicId") Long id, @RequestBody TopicRequest request) {
        try{
            topicService.update(id, request);
            return ResponseEntity.ok("topic 수정 완료!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 ID의 topic이 존재하지 않음");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("topic 수정 중 오류 발생");
        }
    }
}
