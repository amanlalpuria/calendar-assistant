package com.assistant.calendar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {

	@Id
	@Column(name = "Timestamp")
	private Date Timestamp;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "start_time")
	private Date start_time;

	@Id
	@Column(name = "end_time")
	private Date end_time;

	@Column(name = "required")
	private String required;

	@Column(name = "optional")
	private String optional;

	@Column(name = "priority")
	private String priority;

	public Calendar() {

	}

	public Calendar(Date timestamp, String title, String description, Date start_time, Date end_time,
			String required, String optional, String priority) {
		super();
		Timestamp = timestamp;
		this.title = title;
		this.description = description;
		this.start_time = start_time;
		this.end_time = end_time;
		this.required = required;
		this.optional = optional;
		this.priority = priority;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date date) {
		Timestamp = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date isStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public String isPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Calendar [Timestamp=" + Timestamp + ", title=" + title + ", description=" + description
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", required=" + required + ", optional="
				+ optional + ", priority=" + priority + "]";
	}

}
