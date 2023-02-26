package com.fdmgroup.news.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.Principal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import com.fdmgroup.news.controller.CommentControler;
import com.fdmgroup.news.model.Article;
import com.fdmgroup.news.model.Comment;
import com.fdmgroup.news.model.User;
import com.fdmgroup.news.services.ArticleService;
import com.fdmgroup.news.services.CommentService;
import com.fdmgroup.news.services.UserService;

@SpringBootTest
public class CommentControllerTest {

    @MockBean
    private CommentService commentService;

    @MockBean
    private UserService userService;

    @MockBean
    private ArticleService articleService;

    @Autowired
    private CommentControler commentController;

    @Test
    public void testAddComment() {
        Principal principal = Mockito.mock(Principal.class);
        User user = new User();
        user.setUsername("testuser");
        when(userService.findByUsername(principal.getName())).thenReturn(user);

        Article article = new Article();
        article.setId(1);
        when(articleService.findArticleById(article.getId())).thenReturn(article);

        Comment comment = new Comment();
        comment.setText("test comment");

        Model model = Mockito.mock(Model.class);

        String viewName = commentController.addComment(comment, principal, article.getId(), model);

        verify(commentService).addComment(any(Comment.class));
        verify(model).addAttribute("article", article);
        verify(model).addAttribute("comments", article.getComments());
        assertEquals("redirect:/articlePage/" + article.getId(), viewName);
    }
}
