package com.fdmgroup.news.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class ArticleTest {
	
	 private Article article;
	    private User owner;
	    private List<String> photos;
	    
//	    @Before(value = "")
//	    public void setup() {
//	        article = new Article("Test Article");
//	        owner = new User("testuser", "password");
//	        article.setOwner(owner);
//	        photos = Arrays.asList("photo1.jpg", "photo2.jpg", "photo3.jpg");
//	        article.setPhotos(photos);
//	    }
	    
//	   @Test
//	    public void testGetId() {
//	        article.setId(1);
//	        assertEquals(Integer.valueOf(1), article.getId());
//	    }
	    
//	    @Test
//	    public void testGetArticleName() {
//	        assertEquals("Test Article", article.getArticleName());
//	    }
	    
//	    @Test
//	    public void testGetDescription() {
//	        article.setDescription("This is a test article.");
//	        assertEquals("This is a test article.", article.getDescription());
//	    }
	    
//	    @Test
//	    public void testGetCategory() {
////	        article.setCategory("Technology");
//	        assertEquals("Technology", article.getCategory());
//	    }
//	    
//	    @Test
//	    public void testGetOwner() {
//	        assertEquals(owner, article.getOwner());
//	    }
	    
//	    @Test
//	    public void testGetPhotos() {
//	        assertEquals(photos, article.getPhotos());
//	    }
//	    
//	    @Test
//	    public void testSetPhotos() {
////	        article.setPhotos("photo4.jpg");
////	        assertEquals(Arrays.asList("photo1.jpg", "photo2.jpg", "photo3.jpg", "photo4.jpg"), article.getPhotos());
//	    }
	    
	    @Test
	    public void testEquals() {
	        Article article2 = new Article("Test Article", "Test category");
	        article2.setOwner(owner);
//	        article2.setPhotos(photos);
//	        assertTrue(article.equals(article2));
	    }
	    
	    @Test
	    public void testNotEquals() {
	        Article article2 = new Article("Test Article", "Test category");
	        article2.setOwner(owner);
//	        article2.setPhotos(Arrays.asList("photo1.jpg", "photo2.jpg"));
//	        assertFalse(article.equals(article2));
	    }
	    
//	    @Test
//	    public void testHashCode() {
//	        Article article2 = new Article("Test Article");
//	        article2.setOwner(owner);
//	        article2.setPhotos(photos);
//	        assertEquals(article.hashCode(), article2.hashCode());
//	    }
//	
}
