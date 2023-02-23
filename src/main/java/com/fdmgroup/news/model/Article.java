package com.fdmgroup.news.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Article {


	@Id
	@GeneratedValue
	private Integer id;

	private String articleName, 
	               description, 
	               category;
	
	@Column(length = 10000)
	private String articleTextOne,
    			   articleTextTwo,
    			   articleTextThree,
    			   articleTextFour;

	@OneToOne
	private User owner;

	//	private double rating;
	
	@ElementCollection

	private List<String> photos;
	
	
	public Article() {
	}

	public Article(String articleName) {
		super();
		this.articleName = articleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
//
	public User getOwner() {
		return owner;
	}
//
	public void setOwner(User owner) {
		this.owner = owner;
	}

	//	public double getRating() {
	//		return rating;
	//	}

	//	public void setRating(double rating) {
	//		this.rating = rating;
	//	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		if(this.photos== null) {
			this.photos = new ArrayList<String>();
		}
		this.photos.add(photos);
	}


	@Override
	public String toString() {
		return "Article [articleName=" + articleName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, 
				            description, 
				            photos, 
				            articleName, 
				            owner, 
				            //			            rating,
				            articleTextOne,
				            articleTextTwo,
				            articleTextThree,
				            articleTextFour);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(category, other.category)
				&& Objects.equals(description, other.description)
			    && Objects.equals(photos, other.photos)
			    && Objects.equals(owner, other.owner)
				&& Objects.equals(articleName, other.articleName)
				&& Objects.equals(articleTextOne, other.articleTextOne)
		        && Objects.equals(articleTextTwo, other.articleTextTwo)
		        && Objects.equals(articleTextThree, other.articleTextThree)
		        && Objects.equals(articleTextFour, other.articleTextFour);
		        //			&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating);
	}

	public String getArticleTextOne() {
		return articleTextOne;
	}

	public void setArticleTextOne(String articleTextOne) {
		this.articleTextOne = articleTextOne;
	}

	public String getArticleTextTwo() {
		return articleTextTwo;
	}

	public void setArticleTextTwo(String articleTextTwo) {
		this.articleTextTwo = articleTextTwo;
	}

	public String getArticleTextThree() {
		return articleTextThree;
	}

	public void setArticleTextThree(String articleTextThree) {
		this.articleTextThree = articleTextThree;
	}

	public String getArticleTextFour() {
		return articleTextFour;
	}

	public void setArticleTextFour(String articleTextFour) {
		this.articleTextFour = articleTextFour;
	}

}
