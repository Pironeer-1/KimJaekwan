package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.TopicRequest;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.repository.TopicRepository;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public void save(TopicRequest request) {
        Topic topic = Topic.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        topicRepository.save(topic);
    }

    public TopicResponse findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("topic 이 존재하지 않음"));
        return TopicResponse.of(topic);
    }

    public List<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return TopicResponse.getTopicResponses(topics);
    }

    public void delete(Long id) {
        topicRepository.delete(id);
    }

    public void update(Long id, TopicRequest request) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("topic 이 존재하지 않음"));

        if (topic != null) {
            topic.setTitle(request.title());
            topic.setContent(request.content());
            topic.setUpdatedAt(LocalDateTime.now());

            topicRepository.update(id, topic);
        } else {
            throw new IllegalArgumentException("해당 topic이 존재하지 않습니다.");
        }
    }
}
