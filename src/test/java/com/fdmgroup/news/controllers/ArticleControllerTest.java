package com.fdmgroup.news.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fdmgroup.news.controller.ArticleController;
import com.fdmgroup.news.model.Article;
import com.fdmgroup.news.services.IArticleService;
import com.fdmgroup.news.services.LogService;
import com.fdmgroup.news.services.RatingService;
import com.fdmgroup.news.util.Filtering;

@ExtendWith(MockitoExtension.class)

public class ArticleControllerTest {
	
	private MockMvc mockMvc;

    @Mock
    private IArticleService articleService;

    @Mock
    private RatingService ratingService;

    @Mock
    private LogService logService;

    @InjectMocks
    private ArticleController articleController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }

    @Test
    public void testGoArticlePage() throws Exception {
        mockMvc.perform(get("/articlePage"))
               .andExpect(status().isOk())
               .andExpect(view().name("articlePage"));
    }

    @Test
    public void testGoAddArticle() throws Exception {
        mockMvc.perform(get("/addArticle"))
               .andExpect(status().isOk())
               .andExpect(view().name("addArticle"));
    }

    @Test
    public void testCreateNewArticle() throws Exception {
        mockMvc.perform(post("/addArticle")
                .param("articleName", "Test Article")
                .param("description", "Test Description")
                .param("category", "Test Category")
                .param("articleTextOne", "Test Text One")
                .param("articleTextTwo", "Test Text Two")
                .param("articleTextThree", "Test Text Three")
                .param("articleTextFour", "Test Text Four"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/articlePage/1"));
    }

    @Test
    public void testSeeDetails() throws Exception {
        Article article = new Article();
        article.setId(1);
        article.setArticleName("Test Article");
//        when(articleService.findArticleById(1)).thenReturn(article);

//        mockMvc.perform(get("/articlePage/1"))
//               .andExpect(status().isOk())
//               .andExpect(view().name("articlePage"))
//               .andExpect(model().attribute("article", article))
//               .andExpect(model().attribute("articleName", "Test Article"));
    }

    @Test
    public void testDeleteArticle() throws Exception {
        mockMvc.perform(post("/delete")
                .param("id", "1"))
               .andExpect(view().name("index"));
    }

    @Test
    public void testDropDownFilters() throws Exception {
        mockMvc.perform(get("/dropDownFilters"))
               .andExpect(status().isOk())
               .andExpect(view().name("dropDownFilters"));
    }

    @Test
    public void testFilterByIOS() throws Exception {
        mockMvc.perform(post("/filterByIOS"))
               .andExpect(status().isOk())
               .andExpect(view().name("dropDownFilters"));
    }

    @Test
    public void testFilterByAndroid() throws Exception {
        mockMvc.perform(post("/filterByAndroid"))
               .andExpect(status().isOk())
               .andExpect(view().name("dropDownFilters"));
    }

    @Test
    public void testFilterByIT() throws Exception {
        mockMvc.perform(post("/filterByIT"))
               .andExpect(status().isOk())
               .andExpect(view().name("dropDownFilters"));
    }
    
    @Test
    public void testFilterByGlobalNews() throws Exception {
        mockMvc.perform(post("/filterByGlobalNews"))
               .andExpect(status().isOk())
               .andExpect(view().name("dropDownFilters"));
    }
}
