package com.amazonaws.lambda.demo;

import java.util.Map;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClient;
import com.amazonaws.services.stepfunctions.model.DescribeExecutionRequest;
import com.amazonaws.services.stepfunctions.model.DescribeExecutionResult;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DescribeExecution implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("access_key"
    			, "secret_key_id");
        AWSStepFunctions stepFunctions = new AWSStepFunctionsClient(awsCreds);
        stepFunctions.setEndpoint("states.us-west-2.amazonaws.com");;
        DescribeExecutionRequest rq = new DescribeExecutionRequest();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(input, Map.class);
        rq.setExecutionArn(map.get("executionArn").toString());
        DescribeExecutionResult res = stepFunctions.describeExecution(rq);
        
        return res.getOutput();
    }

}
