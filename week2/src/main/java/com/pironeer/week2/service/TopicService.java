package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.repository.TopicRepository;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public void save(TopicCreateRequest request) {
        Topic topic = Topic.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        topicRepository.save(topic);
    }

    public TopicResponse findById(Long id) {
        Topic topic = topicRepository.findById(id);
        return TopicResponse.of(topic);
    }

    public List<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return TopicResponse.getTopicResponses(topics);
    }
}
