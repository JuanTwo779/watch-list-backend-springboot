Overview
- rest api for movie watch list
- connection to RDS/mysql database
- deployed on elastic beanstalk
- JDK: corretto 17

Dependencies
- starter web
- actuator
- hateoas
- spring security
- devtools
- mySQL connector
- JPA
- test
- Spring security
- oauth2 resource server

Beans
-Movie bean
-Award bean
-Demo bean (for testing and AWS health check)

Spring Security
- JWT configuration
- username: 
= password: 

JSON Shortcuts
{
    "username": 
    "password": 
}
{
    "id": 1,
    "username": "juan",
    "title": "Scarface",
    "year": "1983",
    "director": "Brian De Palma",
    "country": "USA",
    "rating": 79,
    "watched": true,
    "awards":[]
}
{
    "awardId": 1,
    "year": "1976",
    "organisation": "BAFTA Film Awards",
    "description": "Best Actor (Al Pacino)"
}

DOCKER (Local)
docker run --detach
--env MYSQL_ROOT_PASSWORD=__
--env MYSQL_USER=__
--env MYSQL_PASSWORD=__
--env MYSQL_DATABASE=__
--name __
--publish 3309:3306
mysql:8-oracle

mySQL (Local)
- \connect watchlist-user@localhost:3309
- pw: __
- db: __

AWS deployment
- rest API on elastic beanstalk
- RDS database configuration
