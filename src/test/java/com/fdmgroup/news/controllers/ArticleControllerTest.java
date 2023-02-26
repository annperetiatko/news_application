package com.fdmgroup.news.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;

import com.fdmgroup.news.controller.ArticleController;
import com.fdmgroup.news.model.Article;
import com.fdmgroup.news.services.ArticleService;
import com.fdmgroup.news.services.IArticleService;
import com.fdmgroup.news.services.LogService;
import com.fdmgroup.news.services.RatingService;
import com.fdmgroup.news.util.Filtering;

@SpringBootTest
public class ArticleControllerTest {
	
	private MockMvc mockMvc;
	
    @Mock
    private ModelMap model;

    @Mock
    private IArticleService articleService;

    @Mock
    private RatingService ratingService;

    @Mock
    private LogService logService;
    
    @Mock
    private ArticleService service;

    @InjectMocks
    private ArticleController articleController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }
    
    @Test
    public void testGoArticlePage() {
        String view = articleController.goArticlePage(model);
        assertEquals("articlePage", view);

        Article article = new Article();
        article.setArticleName("article name");

        Filtering filtering = new Filtering();

        model.addAttribute("article", article);
        model.addAttribute("filtering", filtering);
    }
    
    @Test
    public void testGoAddArticle() {
        when(logService.isLoggedIn(model)).thenReturn(true);
        
        String result = articleController.goAddArticle(model);
        assertEquals("addArticle", result);
        
        verify(logService).isLoggedIn(model);
    }
    
    @Test
    public void createNewArticleTest() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();

    MockMultipartFile image = new MockMultipartFile("image", "test-image.jpg", "image/jpeg", "test image".getBytes());

    mockMvc.perform(MockMvcRequestBuilders.multipart("/addArticle")
            .file("image", image.getBytes())
            .param("articleName", "Test Article")
            .param("description", "This is a test article")
            .param("category", "Technology")
            .param("articleTextOne", "This is a test article.")
            .param("articleTextTwo", "This is a test article.")
            .param("articleTextThree", "This is a test article.")
            .param("articleTextFour", "This is a test article."))
            .andExpect(MockMvcResultMatchers.model().attributeExists("article"))
            .andExpect(MockMvcResultMatchers.model().attribute("articleName", "Test Article"))
            .andExpect(MockMvcResultMatchers.model().attribute("articleDescription", "This is a test article"))
            .andExpect(MockMvcResultMatchers.model().attribute("articleCategory", "Technology"))
            .andExpect(MockMvcResultMatchers.model().attribute("articleTextOne", "This is a test article."))
            .andExpect(MockMvcResultMatchers.model().attribute("articleTextTwo", "This is a test article."))
            .andExpect(MockMvcResultMatchers.model().attribute("articleTextThree", "This is a test article."))
            .andExpect(MockMvcResultMatchers.model().attribute("articleTextFour", "This is a test article."));
    }
    
    @Test
    public void testSeeDetails() throws Exception {

        Article article = new Article();
        article.setId(22);
        article.setArticleName("Test Article");
        article.setDescription("Test Description");
        article.setCategory("Test Category");
        article.setOwner(null);
        article.setArticleTextOne("Test Text 1");
        article.setArticleTextTwo("Test Text 2");
        article.setArticleTextThree("Test Text 3");
        article.setArticleTextFour("Test Text 4");
        when(articleService.findArticleById(22)).thenReturn(article);

        MvcResult result = mockMvc.perform(get("/articlePage/22"))
                .andExpect(status().isOk())
                .andExpect(view().name("articlePage"))
                .andReturn();

        ModelMap model = result.getModelAndView().getModelMap();
        assertEquals(article, model.getAttribute("article"));
        assertEquals("Test Article", model.getAttribute("articleName"));
        assertEquals("Test Description", model.getAttribute("articleDescription"));
        assertEquals("Test Category", model.getAttribute("articleCategory"));
        assertEquals("Test Owner", model.getAttribute("articleOwner"));
        assertEquals("Test Text 1", model.getAttribute("articleTextOne"));
        assertEquals("Test Text 2", model.getAttribute("articleTextTwo"));
        assertEquals("Test Text 3", model.getAttribute("articleTextThree"));
        assertEquals("Test Text 4", model.getAttribute("articleTextFour"));
        assertEquals("Test Photo URL", model.getAttribute("mainPhotoUrl"));
        assertEquals(Collections.singletonList("Test Photo URL"), model.getAttribute("pictureUrls"));
        assertNotNull(model.getAttribute("articleRating"));
        assertEquals("Test Category", model.getAttribute("category"));
        assertNotNull(model.getAttribute("filtering"));
        assertNotNull(model.getAttribute("resultsOfSearchCat"));
        assertNotNull(model.getAttribute("comments"));
    }
    
    @Test
    public void testDropDownFilters() {
        ModelMap model = new ModelMap();
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("category")).thenReturn("TestCategory");
        String filter = "TestFilter";
        String viewName = articleController.filteringFunction(model, request, filter);

        assertEquals("dropDownFilters", viewName);
        Filtering filtering = (Filtering) model.get("filtering");
        assertNotNull(filtering);
        
        List<Article> searchedByCategory = new ArrayList<>(0);
        List<Article> searchedArticles = new ArrayList<>();
        searchedByCategory.add(new Article("Test1", "TestCategory"));
        searchedArticles.add(new Article("Test2", "TestCategory"));
        searchedArticles.add(new Article("Test3", "TestCategory1"));
        when(service.findArticleByCategory("TestCategory")).thenReturn(searchedByCategory);
    }

  
  @Test
  public void testFilterByIOS() {
      when(logService.isLoggedIn(model)).thenReturn(true);

      articleController.filterByIOS(model);

      verify(logService).isLoggedIn(model);
      String result = articleController.filterByIOS(model);

      assertEquals("dropDownFilters", result);
  }
  
  @Test
  public void testFilterByAndroid() {
      when(logService.isLoggedIn(model)).thenReturn(true);

      articleController.filterByAndroid(model);

      verify(logService).isLoggedIn(model);
      String result = articleController.filterByAndroid(model);

      assertEquals("dropDownFilters", result);
  }
  
  @Test
  public void testFilterByIT() {
      when(logService.isLoggedIn(model)).thenReturn(true);

      articleController.filterByIT(model);

      verify(logService).isLoggedIn(model);
      String result = articleController.filterByIT(model);

      assertEquals("dropDownFilters", result);
  }
  
  @Test
  public void testFilterByGlobalNews() {
      when(logService.isLoggedIn(model)).thenReturn(true);

      articleController.filterByGlobalNews(model);

      verify(logService).isLoggedIn(model);
      String result = articleController.filterByGlobalNews(model);

      assertEquals("dropDownFilters", result);
  }

}
