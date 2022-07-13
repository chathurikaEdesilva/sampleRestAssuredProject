# README
This project contains a sample that demonstrates invoking a rest api and validating three test cases.

### Technologies used
- Testng
- Restassured
- Maven
- Java

### Project description
This calls a REST endpoint and validates the follwoing criteria

Name = "Carbon credits"
CanRelist = true
The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"

### Pre-requsists to run the test
- A device with Maven installed
- A device with git installed

### Steps to run

1. Clone below git repository

> git clone https://github.com/chathurikaEdesilva/sampleRestAssuredProject.git

2. Go to the repository

> cd $project_home

3. Clean the repository

> mvn clean

4. Run the repository

> mvn test

### Viewing the result file

You can view the results from the following methods

1. Go to following location and open testng-results.xml

> $project_home/target/surefire-reports

2. Go to the above location and open emailable-report.html to view in browser
