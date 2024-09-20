package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record TopicResponse(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {

    public static TopicResponse of(Topic topic) {
        return new TopicResponse(
                topic.getId(),
                topic.getTitle(),
                topic.getContent(),
                topic.getCreatedAt(),
                topic.getUpdatedAt()
        );
    }

    public static List<TopicResponse> getTopicResponses(List<Topic> topics) {
        return topics.stream()
                .map(TopicResponse::of)
                .collect(Collectors.toList());
    }
}
