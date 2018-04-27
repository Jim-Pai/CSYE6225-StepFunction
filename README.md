# CSYE6225-StepFunction

Public API to invoke Amazon Step Function:

[https://wwrgqdeci2.execute-api.us-west-2.amazonaws.com/alpha/registration](https://wwrgqdeci2.execute-api.us-west-2.amazonaws.com/alpha/registration)

Request Body should be this format:
```javascript
{
   "input": "{\"Student\": {\"id\":\"assign_an_id\",\"studentName\":\"name\",\"email\":\"xxx@gmail.com\"},\"CourseId\":\"csye6225\",\"Register\":boolean}",
   "stateMachineArn": "arn:aws:states:us-west-2:806121996369:stateMachine:CourseRegistration"
}
```

You will get a response with body like this:
```javascript
{
  "executionArn": "string",
  "startDate": 1524815393.214
}
```

Record the executionArn to retrieve the output of state machine.

Public API to retrieve the output of state machine:

[https://wwrgqdeci2.execute-api.us-west-2.amazonaws.com/alpha/description](https://wwrgqdeci2.execute-api.us-west-2.amazonaws.com/alpha/description)

You have to wait a moment until state machine stop running.

Request body should be this format:
```javascript
{
   "executionArn": "string"
}
```
Then the output will be in the response body.


