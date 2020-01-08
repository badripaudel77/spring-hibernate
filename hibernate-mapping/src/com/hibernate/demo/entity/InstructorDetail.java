package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//annotate the class
@Entity
@Table(name="instructor_detail")

public class InstructorDetail {

	//define fields 
	//map the column to db names
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube")
	private String youtube;
	
	@Column(name="hobby")
	private String hobby;
	
	public InstructorDetail() {
		
	}

	//generate consturctor
	public InstructorDetail(String youtube, String hobby) {
		
		this.youtube = youtube;
		this.hobby = hobby;
	}
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	//generate toString method
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube=" + youtube + ", hobby=" + hobby + "]";
	}

}
