package com.akashSpringLearning.springpractice.StudentModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Student_1")
public class StudentModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	@Column(name="Name")
	private String name;
	@Column(name="School_Name")
	private String SchoolName;
	@Column(name="Grade")
	private int grade;
	
	
	public StudentModel() {
		super();
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

}
