package com.amazonaws.lambda.demo;

import java.util.HashSet;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTable(tableName = "Students")
public class Student{
	public String id;
	public String studentName;
	public String email;
	public Set<String> courses;
	
	@DynamoDBHashKey(attributeName = "StudentId")
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id;}
	
	@DynamoDBAttribute(attributeName = "StudentName")
	public String getName() { return this.studentName; } 
	public void setName(String studentName) { this.studentName = studentName; }
	
	@DynamoDBAttribute(attributeName = "Email")
	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
	
	@DynamoDBAttribute(attributeName = "Courses")
	@DynamoDBTypeConverted(converter = DynamoDBSetCoverter.class)
	public Set<String> getCourses() {
		if(this.courses == null)
			this.courses = new HashSet<>();
		return this.courses;
	}
	
	public void setCourses(Set<String> courses) {
		if(courses.size() == 0) {
			this.courses = null;
			return;
		}
		this.courses = courses;
	}
}
