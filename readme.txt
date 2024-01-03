Overview
- rest api for movie watch list
- connection to RDS/mysql database
- deployed on elastic beanstalk
- JDK: corretto 17

Beans
-Movie bean
-Award bean
-Demo bean (for testing and AWS health check)

Spring Security
- JWT configuration
- username: juan
= password: Astig-09

JSON Shortcuts
{
    "username": "juan",
    "password": "Astig-09"
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
--env MYSQL_ROOT_PASSWORD=DBpassword-09
--env MYSQL_USER=watchlist-user
--env MYSQL_PASSWORD=DBpassword-09
--env MYSQL_DATABASE=watchlist-database
--name mysqlWatchList
--publish 3309:3306
mysql:8-oracle

mySQL (Local)
- \connect watchlist-user@localhost:3309
- pw: DBpassword-09
- db: watchlist-database

AWS deployment
- rest API on elastic beanstalk
- RDS database configuration
