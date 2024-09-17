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

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    public void save(CommentRequest request) {
        topicRepository.findById(request.topicId())
                        .orElseThrow(() -> new RuntimeException("topic 이 존재하지 않음"));
        topicRepository.findById(request.parentComentId())
                        .orElseThrow(() -> new RuntimeException("부모 comment 가 존재하지 않음"));
        commentRepository.save(CommentMapper.from(request));
    }

    public CommentResponse findById(Long id) {
        Comment comment = vaildateCommentById(id);
        return CommentResponse.of(comment);
    }

    /*
    id로 해당 comment 가 repository 에 존재하는지 검증
     */
    private Comment vaildateCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("comment 가 존재하지 않음"));
    }

    public List<CommentResponse> findRepliesByParentId(Long parentId) {
        vaildateCommentById(parentId);
        List<Comment> replies = commentRepository.findByParentId(parentId);
        return CommentResponse.getCommentResponses(replies);
    }

    public void delete(Long id) {
        vaildateCommentById(id);
        List<Comment> replies = commentRepository.findByParentId(id);

        for (Comment reply : replies) {
            commentRepository.deleteCommentById(reply.getId());
        }

        commentRepository.deleteCommentById(id);
    }
}
