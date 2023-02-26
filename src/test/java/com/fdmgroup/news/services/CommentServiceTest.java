package com.fdmgroup.news.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fdmgroup.news.model.Article;
import com.fdmgroup.news.model.Comment;
import com.fdmgroup.news.repository.CommentRepository;

@SpringBootTest
public class CommentServiceTest {
    
    @Mock
    private CommentRepository commentRepository;
    
    @InjectMocks
    private CommentService commentService;
    
    private Article article;
    
    @Test
    public void testAddComment() {
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setText("Test comment");
        comment.setArticle(article);
        
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);
        
        Comment savedComment = commentService.addComment(comment);
        Assertions.assertEquals(comment, savedComment);
    }
    
    @Test
    public void testGetCommentsByArticle() {
        Comment comment1 = new Comment();
        comment1.setId(1L);
        comment1.setText("Test comment 1");
        comment1.setArticle(article);
        
        Comment comment2 = new Comment();
        comment2.setId(2L);
        comment2.setText("Test comment 2");
        comment2.setArticle(article);
        
        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        
        when(commentRepository.findByArticle(article)).thenReturn(comments);
        
        List<Comment> foundComments = commentService.getCommentsByArticle(article);
        Assertions.assertEquals(2, foundComments.size());
        Assertions.assertEquals(comment1, foundComments.get(0));
        Assertions.assertEquals(comment2, foundComments.get(1));
    }
}
