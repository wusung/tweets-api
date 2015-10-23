How to use
==========

##Scenario
An insurance company needs a system to tweet their current statuses.  A software engineering team is working on the story below.

*As a system user, I want to add new user data into the system. After added, I can view a certain user, an user list, and sign in with the new user email and password.

## Demo site
You can see available users here. https://tweets-example-api.herokuapp.com/rest/user

## Instructions
Strongly suggest you use curl utility to test the following codes.

### Creating a single user
```
curl -H "Content-Type: application/json" -XPOST https://tweets-example-api.herokuapp.com/rest/user -u franky@gmail.com:1234 -d '{
    "id": 11,
    "name": "Wusung",
    "password": "1234",
    "email": "wusung@gmail.com"
}
'
```

### Updating a single user
```
curl -H "Content-Type: application/json" -XPUT https://tweets-example-api.herokuapp.com/rest/user/11 -u franky@gmail.com:1234 -d '{
        "name": "Wusung Peng",
        "password": "1234",
        "email": "wusung@gmail.com"
}
'
```

### Reading a single user
```
curl -XGET https://tweets-example-api.herokuapp.com/rest/user/11 -u wusung@gmail.com:1234
```

### Listing all customers
```
curl -XGET https://tweets-example-api.herokuapp.com/rest/user -u wusung@gmail.com:1234
```

### Creating a tweet
```
curl -H "Content-Type: application/json" -XPOST https://tweets-example-api.herokuapp.com/rest/status -u wusung@gmail.com:1234 -d '{
    "id": 1,
    "message": "Hello tweet",
    "userId": "11"
}'
```

### Listing all tweets
```
curl -XGET https://tweets-example-api.herokuapp.com/rest/status -u wusung@gmail.com:1234
```

### Reading a single tweet
```
curl -XGET https://tweets-example-api.herokuapp.com/rest/status/1 -u wusung@gmail.com:1234
```
