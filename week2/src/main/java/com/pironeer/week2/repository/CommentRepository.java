package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap = new HashMap<>();

    public void save(Comment comment) {
        if (comment.getId() == null){
            Long id = commentIdxGenerator.getAndIncrement();
            comment.setId(id);
            commentMap.put(id, comment);
        } else {
            commentMap.replace(comment.getId(), comment);
        }
    }

    public Optional<Comment> findById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(commentMap.get(id));
    }
}
