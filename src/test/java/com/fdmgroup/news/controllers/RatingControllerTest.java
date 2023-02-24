package com.fdmgroup.news.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

import com.fdmgroup.news.controller.RatingController;
import com.fdmgroup.news.model.Article;
import com.fdmgroup.news.model.Rating;
import com.fdmgroup.news.services.ArticleService;
import com.fdmgroup.news.services.LogService;
import com.fdmgroup.news.services.RatingService;

public class RatingControllerTest {
	
	@InjectMocks
	private RatingController ratingController;
	
	@Mock
	private RatingService ratingService;
	
	@Mock
	private ArticleService articleService;
	
	@Mock
	private LogService logService;
	
	@Mock
	private ModelMap modelMap;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void save_ShouldSaveRatingAndRedirectToArticlePage() {
		// Arrange
		Article article = new Article();
		article.setId(1);
		when(articleService.findArticleById(1)).thenReturn(article);
		
		Rating rating = new Rating();
		rating.setArticleValue(3);
	}
	
//	@Test
//	public void save_ShouldRedirectToArticlePage() {
//		// Act
//		String result = ratingController.save(modelMap);
//		
//		// Assert
//		assertThat(result).isEqualTo("redirect:/ArticlePage");
//	}

}
