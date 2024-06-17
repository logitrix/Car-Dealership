Development: Monday, June 17, 2024 - 10am

Spring Boot + Spring Web + JPA on Java 17

## Tools
Java 17

Apache Maven 3.8.7

## Library

spring-boot-starter-parent 3.3.0



## Usage

```java
# After cloning the repo run & build using maven
'mvn clean install'

# When successfully build
'mvn spring-boot:run'

# Use Web Context Path '/search'

# Web Application Available with the following input to filter
# Car Model Search Key  'Search for The Car Name Model'
# Car Length  'Define the Minimum and Maximum Length to Filter'
# Car Weight  'Define the Minimum and Maximum Weight to Filter'
# Car Velocity  'Define the Minimum and Maximum Velocity to Filter'
# Car Colors Available   'Select for Colors available to Filter'

# There were no function to add/edit/delete data as not stated in the requirement
but intial data can be edit in the file 'DemoData' class. Follow the code in the file.

'repo.save(new Car("BMW iX", BigDecimal.valueOf(4938), BigDecimal.valueOf(3200), BigDecimal.valueOf(160), "RED"));'
```
![Home Page](https://raw.githubusercontent.com/logitrix/Car-Dealership/master/home_page_screen_capture.jpg)







