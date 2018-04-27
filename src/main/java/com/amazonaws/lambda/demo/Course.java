package com.amazonaws.lambda.demo;

import java.util.HashSet;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
@DynamoDBTable(tableName = "Courses")
public class Course{
	public String id;
	public String courseName;
	public String professorId;
	public Set<String> announcements;
	public Set<String> students;
	public Set<String> lectures;
	//board, roster
	
	@DynamoDBHashKey(attributeName = "CourseId")
	public String getId() { return this.id; }
	public void setId(String courseId) { this.id =  courseId; } 
	
	@DynamoDBAttribute(attributeName = "CourseName")
	public String getCourseName() { return this.courseName; }
	public void setCourseName(String courseName) { this.courseName = courseName; }
	
	@DynamoDBAttribute(attributeName = "ProfessorId")
	public String getProfessorId() { return this.professorId; }
	public void setProfessorId(String professorId) { this.professorId = professorId; }
	
	@DynamoDBAttribute(attributeName = "Announcements")
	@DynamoDBTypeConverted(converter = DynamoDBSetCoverter.class)
	public Set<String> getAnnouncements() {
		if(this.announcements == null)
			this.announcements = new HashSet<>();
		return this.announcements;
	} 
	
	public void setAnnouncements(Set<String> announcements) { this.announcements = announcements; }
	
	@DynamoDBAttribute(attributeName = "Students")
	@DynamoDBTypeConverted(converter = DynamoDBSetCoverter.class)
	public Set<String> getStudents() {
		if(this.students == null)
			this.students = new HashSet<>();
		return this.students;
	} 
	
	public void setStudents(Set<String> students) { this.students = students; }
	
	@DynamoDBAttribute(attributeName = "Lectures")
	@DynamoDBTypeConverted(converter = DynamoDBSetCoverter.class)
	public Set<String> getLectures() {
		if(this.lectures == null)
			this.lectures = new HashSet<>();
		return this.lectures;
	} 
	
	public void setLectures(Set<String> lectures) { this.lectures = lectures; }
}
