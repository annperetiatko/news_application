package com.fdmgroup.news.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTest {
	
	private Comment comment;
	
	@BeforeEach
	public void setUp() {
		comment = new Comment();
	}
	
	@Test
	public void testGetId() {
		Long id = 1L;
		comment.setId(id);
		assertEquals(id, comment.getId());
	}
	
	@Test
	public void testSetId() {
		Long id = 1L;
		comment.setId(id);
		assertEquals(id, comment.getId());
	}
	
	@Test
	public void testGetText() {
		String text = "test";
		comment.setText(text);
		assertEquals(text, comment.getText());
	}
	
	@Test
	public void testSetText() {
		String text = "test";
		comment.setText(text);
		assertEquals(text, comment.getText());
	}
	
	@Test
	public void testGetUser() {
		User user = mock(User.class);
		comment.setUser(user);
		assertEquals(user, comment.getUser());
	}
	
	@Test
	public void testSetUser() {
		User user = mock(User.class);
		comment.setUser(user);
		assertEquals(user, comment.getUser());
	}
	
	@Test
	public void testGetArticle() {
		Article article = mock(Article.class);
		comment.setArticle(article);
		assertEquals(article, comment.getArticle());
	}
	
	@Test
	public void testSetArticle() {
		Article article = mock(Article.class);
		comment.setArticle(article);
		assertEquals(article, comment.getArticle());
	}
	
	@Test
	public void testHashCode() {
		Long id = 1L;
		String text = "test";
		User user = mock(User.class);
		Article article = mock(Article.class);
		
		comment.setId(id);
		comment.setText(text);
		comment.setUser(user);
		comment.setArticle(article);
		
		int expectedHashCode = Objects.hash(article, id, text, user);
		assertEquals(expectedHashCode, comment.hashCode());
	}
	
	@Test
	public void testEqualsWithSameComment() {
		assertTrue(comment.equals(comment));
	}
	
	@Test
	public void testEqualsWithDifferentObject() {
		assertFalse(comment.equals(new Object()));
	}
	
	@Test
	public void testEqualsWithNull() {
		assertFalse(comment.equals(null));
	}
	
	@Test
	public void testEqualsWithDifferentId() {
		Long id1 = 1L;
		Long id2 = 2L;
		comment.setId(id1);
		Comment other = new Comment();
		other.setId(id2);
		assertFalse(comment.equals(other));
	}
	
	@Test
	public void testEqualsWithDifferentText() {
		String text1 = "test1";
		String text2 = "test2";
		comment.setText(text1);
		Comment other = new Comment();
		other.setText(text2);
		assertFalse(comment.equals(other));
	}
	
	@Test
	public void testEqualsWithDifferentUser() {
		User user1 = mock(User.class);
		User user2 = mock(User.class);
		comment.setUser(user1);
		Comment other = new Comment();
		other.setUser(user2);
		assertFalse(comment.equals(other));
	}
	
	 @Test
	    public void testToString() {
	        User user = Mockito.mock(User.class);
	        Mockito.when(user.getFirstName()).thenReturn("John Doe");
	        
	        Article article = Mockito.mock(Article.class);
	        Mockito.when(article.getArticleName()).thenReturn("Sample Article");
	        
	        Comment comment = new Comment();
	        comment.setId(1L);
	        comment.setText("This is a sample comment");
	        comment.setUser(user);
	        comment.setArticle(article);
	        
	        String expected = "Comment [id=1, text=This is a sample comment, user=John Doe, article=Sample Article]";
	        
	        String actual = comment.toString();
	 }
}

