package com.hibernate;

import javax.persistence.Embeddable;

//@Embeddable Annotation -if we Annotate with @Embeddable so we can Embedd This Field In Other Table As well.
//Here in This Example we have embeed this field in Student Class.

@Embeddable
public class Certificate {

	private String course;
	private String duration;
	private String fees;

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificate(String course, String duration, String fees) {
		super();
		this.course = course;
		this.duration = duration;
		this.fees = fees;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

}
