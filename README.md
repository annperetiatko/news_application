# News Website - Spring Boot Application

The news website is a basic spring boot application allowing users to view, rate, comment on articles, and add new ones.

- Comments and ratings added by one user can be seen by other users.
- The 'Top Rated News' category is visible only to logged-in users and contains articles with the highest ratings left by all of the users. You can try it by adding a rating to an article and you will see how the category will change. It will also be changed for other users.
- You can add a new user - but after adding it, you will need to log in again with new credentials.

Technologies used:
- 
- Spring Boot
- H2 database
- Spring Security (for user authentication)
- JSP/CSS (for frontend styling)
- Maven (for build and dependency management)

Installation:
-
1. Clone the repository from GitHub:
   ```
   git clone https://github.com/your-username/news-website.git
   ```
3. Navigate to the project directory:
   ```
   cd news-website
   ```
5. Build the project using Maven:
   ```
   mvn clean install
   ```
7. Run the News Website application:
   ```
   mvn spring-boot:run
   ```
9. Finally, access the website by visiting http://localhost:8088

Screenshots:
-

