package com.fdmgroup.news.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import com.fdmgroup.news.services.ArticleService;
import com.fdmgroup.news.services.LogService;
import com.fdmgroup.news.controller.NewsController;
import com.fdmgroup.news.model.Article;

public class NewsControllerTest {
	
	 @Mock
	    private LogService loginService;

	    @Mock
	    private ArticleService articleService;

	    @Mock
	    private ModelMap model;

	    @InjectMocks
	    private NewsController newsController;

	    @Test
	    public void testGoToIndex() {
	        // Given
	        Article article1 = new Article();
	        article1.setArticleName("Article 1");
	        Article article2 = new Article();
	        article2.setArticleName("Article 2");
	        Article article3 = new Article();
	        article3.setArticleName("Article 3");
	    }

	    @Test
	    public void testFaq() {
	        // When
	        String viewName = newsController.faq(model);

	        // Then
	        verify(loginService).isLoggedIn(model);
	        assertEquals("faq", viewName);
	    }

	    @Test
	    public void testAboutUs() {
	        // When
	        String viewName = newsController.aboutUs(model);

	        // Then
	        verify(loginService).isLoggedIn(model);
	        assertEquals("aboutUs", viewName);
	    }

	    @Test
	    public void testTerms() {
	        // When
	        String viewName = newsController.terms(model);

	        // Then
	        verify(loginService).isLoggedIn(model);
	        assertEquals("terms", viewName);
	    }


}
