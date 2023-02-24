package com.fdmgroup.news.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.news.model.Article;
import com.fdmgroup.news.model.Rating;
import com.fdmgroup.news.repository.RatingRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class RatingServiceTest {
	
	@Mock
	private RatingRepository ratingRepository;
	
	@InjectMocks
	private RatingService ratingService;

	    @Test
	    public void testGetAverageArticleRating() {
	        Article article = new Article();
	        Rating rating1 = new Rating();
	        rating1.setId(1L);
	        rating1.setArticle(article);
	        rating1.setArticleValue(4);
	        Rating rating2 = new Rating();
	        rating2.setId(2L);
	        rating2.setArticle(article);
	        rating2.setArticleValue(3);
	        List<Rating> ratings = new ArrayList<>();
	        ratings.add(rating1);
	        ratings.add(rating2);
	        when(ratingRepository.findByArticle(article)).thenReturn(ratings);
	        double expectedAverage = 3.5;
	        double actualAverage = ratingService.getAverageArticleRating(article);
	        assertEquals(expectedAverage, actualAverage, 0.0);
	    }

}
