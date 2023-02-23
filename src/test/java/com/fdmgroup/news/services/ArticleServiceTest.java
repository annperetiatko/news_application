package com.fdmgroup.news.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.fdmgroup.news.model.Article;

@SpringBootTest
public class ArticleServiceTest {
	@Autowired
	ArticleService articleService = new ArticleService();
	
	@BeforeEach
	public void dropTables() {
		List<Article> articlesToDelete = articleService.findAllArticles();
		for (Article article : articlesToDelete) {
			articleService.deleteArticle(article.getId());
		}
	}
	
	@Test
	public void test_findArticleByNameWhenExists() {
		Article article = new Article();
		article.setArticleName("name");
		articleService.createNewArticle(article);
		
		assertEquals(article.getId(), articleService.findByArticleName("name").getId());
	}
	
	@Test
	public void test_findNoArticleByNameWhenNoneExists() {
		Article article = new Article();
		article.setArticleName("name1");
		articleService.createNewArticle(article);
		
		assertNotEquals(article.getId(), articleService.findByArticleName("name2").getId());
	}
	
	@Test
	public void test_deleteSingleEntry() {
		Article article1 = new Article();
		article1.setArticleName("name1");
		articleService.createNewArticle(article1);

		Article article2 = new Article();
		article2.setArticleName("name2");
		articleService.createNewArticle(article2);
		
		assertEquals(2, articleService.findAllArticles().size());
		
		articleService.deleteArticle(article1.getId());

		assertEquals(1, articleService.findAllArticles().size());
		assertEquals(article2.getId(), articleService.findAllArticles().get(0).getId());
	}
}
