package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    private final Map<Long, Topic> topicMap = new HashMap<Long, Topic>();

    public void save(Topic topic) {
        Long id = topicIdxGenerator.getAndIncrement();
        topic.setId(id);
        topicMap.put(topicIdxGenerator.getAndIncrement(), topic);
    }

    public Topic findById(Long id) {
        return topicMap.get(id);
    }

    public List<Topic> findAll() {
        return new ArrayList<>(topicMap.values());
    }
}
