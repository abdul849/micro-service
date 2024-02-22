package Comment.Comment.service;

import Comment.Comment.config.RestTemplateConfig;
import Comment.Comment.entity.Comment;
import Comment.Comment.payload.Post;
import Comment.Comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RestTemplateConfig restTemplate;

    public Comment saveComment(Comment comment){
     Post post=   restTemplate.getrestTemplate().getForObject("http://localhost:8081/api/post/"+comment.getPostId(), Post.class);
     if(post!=null){
         String commentId = UUID.randomUUID().toString();
         comment.setCommentId(commentId);
         Comment  savedComment = commentRepository.save(comment);
         return savedComment;
     }
     else {
         return null;
     }

    }


    public List<Comment> getAllCommentByPostId(String postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;
    }
}
