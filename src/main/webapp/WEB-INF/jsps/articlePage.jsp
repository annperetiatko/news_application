<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/style.css">
  <title>Document</title>
</head>
<body background="${article.photos[0]}">
<!-- <body> -->
  <div class="wrapper">
    <header class="header">
     <%@ include file="headerBar.jsp" %>
    </header>
    <main class="main">
       <div class="main__article--container">
        <div class="main__title-article">${article.articleName}</div>
         <p class="main__subtitle-article">Rating: ${articleRating}</p>
        <div class="main__article--text">
          <p class="text--one">${article.articleTextOne}</p>
          <p class="text--two">${article.articleTextTwo}</p>
          <p class="text--three">${article.articleTextThree}</p>
          <p class="text--four">${article.articleTextFour}</p>
        </div>
        
            <div class="product-button-row-two">
              <div class="main__rate-article">Rate the article:</div>
                <div class="main__rate-article--input" id="rate">
                
                  <form action="/rate/${id}" method="post" class="rate-form">                   
                    <label for="value"></label><br>
					  <input 
					  	id="value" 
					  	class="input_rate"
					  	type="number" 
					  	name="articleValue"
					  	min="0"
					  	max="5"
						placeholder="Place article rating here"
					  >
                    <input type="submit" value="Rate" class="rate-button">
                  </form>  
                </div>
              </div>
      </div>
    </main>
    <footer class="footer">
    <%@ include file="footerBar.jsp" %>
    </footer>
  </div>
</body>
</html>