#


 - Spring Boot 2
 - Spring Webflux
 - Spring Reactive Data MongoDb
 - Spring Security Reactive Webflux


<br/>

## Running

In application.properties, configure appropriate values.
<br/>
<br/>
Run this using using the gradle wrapper included

```
./gradlew bootRun
```

And then go to http://localhost:8080 to test the API's.


## cURL Commands

You can try the following API's once the server is running.

GET __/user__

``` curl http://localhost:8080/user -v -u brijesh:password```

GET __/user/{id}__

``` curl http://localhost:8080/user/{id} -v -u brijesh:password```

POST __/user__

``` curl -X POST -d '{
  "userId": "jame@xyz.com",
  "userName": {
    "firstName": "Jame",
    "middleName": "Andy",
    "lastName": "James"
  },
  "password": "james",
  "role": "ADMIN",
  "insertedBy": "james@xyz.com",
  "insertedDate": "1530816178",
  "updatedBy": "james@xyz.com",
  "updatedDate": "1530816178",
  "socialProfile": {
    "linkedIn": "https://www.linkedin.com",
    "skypeId": "jamesh",
    "facebook": "james",
    "twitter": "james",
    "instagram": "james"
  },
  "contact": {
    "personalPhone": "800-645-6758",
    "workPhone": "800-645-6758",
    "otherPhone": "800-645-6758"
  }
}' -H "Content-Type: application/json" http://localhost:8080/user -v -u brijesh:password```
