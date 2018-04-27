package com.amazonaws.lambda.demo;

import java.util.Map;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CreateStudent implements RequestHandler<Object, Object> {
	
	private static AmazonDynamoDB dynamoDb;
	private static DynamoDBMapper mapper;
	
    @Override
    public Object handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        init();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(input, Map.class);
        Student student = new Student();
        Object studentObj = map.get("Student");
        Map<String, Object> studentMap = objectMapper.convertValue(studentObj, Map.class);
        student.setId(studentMap.get("id").toString());
        student.setName(studentMap.get("studentName").toString());
        student.setEmail(studentMap.get("email").toString());
        mapper.save(student);
        return input;
    }
    
    private void init() {
    		BasicAWSCredentials awsCreds = new BasicAWSCredentials("access_key"
				, "secret_key_id");
		
		dynamoDb = AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withRegion(Regions.US_WEST_2)
				.build();
		
		mapper = new DynamoDBMapper(dynamoDb);
    }
}




