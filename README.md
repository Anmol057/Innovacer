# Innovacer
### Technologies Used:
---
* Spring Framework
* MVC Architecture
* HTML
* CSS
* Javascript
* Ajax
* JSON
* Java
* SQL

### Technical Description
---

A dynamic webpage for entry management software using spring framework which is an application framework used as an inversion of control container for the Java platform. It is using Model-View-Controller architectural pattern where front-end is using technologies html, css, javascript. And data flow takes place using ajax to the server and sent as a json object in post type request. 

A model is constructed defining all the parameters required for data entry with each parameter having it's separate attributes assigned to specify it's kind.

A view is made in which on pressing "Submit", data validation takes place on the front-end itself, checking for correct mail id and phone number. After submission of correct values, this data is sent in the form of json object to the controller using ajax.
A Controller is constructed for where all the data coming from webpage is used and passed on to a function which is used to mail the user. Function takes parameters as mail Id and content and mails the users with the details of his visit to the company. Initially all the details with time stamp is passed on to another class which is connected to sql database to write into the database and when all the data is required to mail the person again, all the details are extracted from the database and then passed on to a function. This function mails the user including all his details regarding his company visit. 
This project use Gradle which is an open-source build-automation system that introduces a Groovy-based domain-specific language instead of the XML form, which is used by Apache Maven for declaring the project configuration. With its help, all the required jars for the project such as jdbc driver, spring-boot-starter-web, spring-boot-devtools and all other necessary jars are injected. In application.properties, file server address and port are defined where webpage will run and prefix and suffix are set for binding the url with these while traversing from one page to another.

### Requirements:
---
MySQL back up file
Tomcat Server
Java 1.8
2 libraries mail.jar and mysql-connector-java-5.1.48

### Installation:
---
Put the code on Apache web server deploy the code base, add MYSQL backup file, set port for MYSQL as 3306 and use Gradle as build-automation-system.In spring starter project add all 5 java classes named InnovacerBean.java, Login3FrontendApplicaton.java, RequestInfo.java,ServletInitializer.java, WebController.java.Change the application.properties file as given in repository. In src-> main-> make a new folder webapp, inside which make a folder named as WEB-INF inside which make folder jsp and place request.jsp in jsp folder.

### Instructions to run the code
---
Deploy the code on Apache Tomcat web server and type localhost:8080 on any web browser.
