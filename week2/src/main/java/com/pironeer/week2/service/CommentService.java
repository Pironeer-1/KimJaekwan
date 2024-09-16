package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.CommentRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.mapper.CommentMapper;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.TopicRepository;
import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    public void save(CommentRequest request) {
        Topic topic = topicRepository.findById(request.topicId())
                .orElseThrow(() -> new RuntimeException("topic 이 존재하지 않음"));
        commentRepository.save(CommentMapper.from(request));
    }

    public CommentResponse findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("comment가 존재하지 않음"));
        return CommentResponse.of(comment);
    }
}
