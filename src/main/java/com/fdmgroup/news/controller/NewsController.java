package com.fdmgroup.news.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdmgroup.news.services.ArticleService;
import com.fdmgroup.news.model.Article;
import com.fdmgroup.news.services.LogService;

@Controller
public class NewsController {
	
	@Autowired
	private LogService login;
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping(value = "/")
	public String goToIndex(ModelMap model) {
		login.isLoggedIn(model);
		List<Article> allArticles = articleService.findAllArticles();
		
		Collections.shuffle(allArticles);
	    List<Article> listOfArticles = allArticles.subList(0, 3);
		model.addAttribute("listOfArticles", listOfArticles);
	
		Collections.shuffle(allArticles);
	    List<Article> listOfArticlesTwo = allArticles.subList(8, 10);
		model.addAttribute("listOfArticlesTwo", listOfArticlesTwo);
		
		Collections.shuffle(allArticles);
	    List<Article> listOfArticlesThree = allArticles.subList(4, 5);
		model.addAttribute("listOfArticlesThree", listOfArticlesThree);
		return "index";
	}
	
	@GetMapping("/faq")
	public String faq(ModelMap model) {
		login.isLoggedIn(model);
		return "faq";
	}
	
	@GetMapping("/aboutUs")
	public String aboutUs(ModelMap model) {
		login.isLoggedIn(model);
		return "aboutUs";
	}
	
	@GetMapping("/terms")
	public String terms(ModelMap model) {
		login.isLoggedIn(model);
		return "terms";
	}
	

}
