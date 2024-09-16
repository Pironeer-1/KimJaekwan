package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.CommentRequest;
import com.pironeer.week2.mapper.CommentMapper;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.TopicRepository;
import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    public void save(CommentRequest request) {
        Topic topic = topicRepository.findById(request.topicId());
        if(topic != null) {
            commentRepository.save(CommentMapper.from(request));
        } else {
            throw new RuntimeException("해당 topic이 존재하지 않습니다.");
        }
    }
}
