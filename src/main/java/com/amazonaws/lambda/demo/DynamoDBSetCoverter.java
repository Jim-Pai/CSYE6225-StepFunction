package com.amazonaws.lambda.demo;

import java.util.HashSet;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class DynamoDBSetCoverter implements DynamoDBTypeConverter<String, Set<String>>{

	@Override
	public String convert(Set<String> set) {
		StringBuilder sBuilder = new StringBuilder();
		for(String s : set)
			sBuilder.append(s + ",");
		return sBuilder.toString();
	}

	@Override
	public Set<String> unconvert(String string) {
		String[] items = string.split(",");
		Set<String> set = new HashSet<>();
		for(String item : items)
			set.add(item);
		return set;
	}

}
