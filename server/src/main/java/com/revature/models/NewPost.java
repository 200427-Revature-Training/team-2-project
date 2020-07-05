package com.revature.models;

import java.sql.Timestamp;

public class NewPost {
	private int statusId;
	private String username;
	private Timestamp datePosted;
	private String title;
	private String message;
	
	
	public NewPost(int statusId, String username, Timestamp datePosted, String title, String message) {
		super();
		this.statusId = statusId;
		this.username = username;
		this.datePosted = datePosted;
		this.title = title;
		this.message = message;
	}
	
	
	public NewPost() {
		super();
		
		
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePosted == null) ? 0 : datePosted.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + statusId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewPost other = (NewPost) obj;
		if (datePosted == null) {
			if (other.datePosted != null)
				return false;
		} else if (!datePosted.equals(other.datePosted))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (statusId != other.statusId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NewPost [statusId=" + statusId + ", username=" + username + ", datePosted=" + datePosted + ", title="
				+ title + ", message=" + message + "]";
	}
	
	
	
}