package com.revature.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "react_reply")
public class ReactReply {
	
	@Id//id is set to be the primary key
	private int rid;
	private int ticketPostId;
	
	@Column(name="timestamp")
	private Date timePosted;
	
	private String userFirstName;
	private String userLastName;
	private String userImage;
	private String replies;
	
	
	public ReactReply(int rid, int ticketPostId, Date timePosted, String userFirstName, String userLastName,
			String userImage, String replies) {
		super();
		this.rid = rid;
		this.ticketPostId = ticketPostId;
		this.timePosted = timePosted;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userImage = userImage;
		this.replies = replies;
	}
	
	
	public ReactReply() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public int getTicketPostId() {
		return ticketPostId;
	}


	public void setTicketPostId(int ticketPostId) {
		this.ticketPostId = ticketPostId;
	}


	public Date getDate() {
		return timePosted;
	}


	public void setDate(Date timePosted) {
		this.timePosted = timePosted;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserImage() {
		return userImage;
	}


	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}


	public String getReplies() {
		return replies;
	}


	public void setReplies(String replies) {
		this.replies = replies;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((replies == null) ? 0 : replies.hashCode());
		result = prime * result + rid;
		result = prime * result + ticketPostId;
		result = prime * result + ((timePosted == null) ? 0 : timePosted.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userImage == null) ? 0 : userImage.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
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
		ReactReply other = (ReactReply) obj;
		if (replies == null) {
			if (other.replies != null)
				return false;
		} else if (!replies.equals(other.replies))
			return false;
		if (rid != other.rid)
			return false;
		if (ticketPostId != other.ticketPostId)
			return false;
		if (timePosted == null) {
			if (other.timePosted != null)
				return false;
		} else if (!timePosted.equals(other.timePosted))
			return false;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userImage == null) {
			if (other.userImage != null)
				return false;
		} else if (!userImage.equals(other.userImage))
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ReactReplies [rid=" + rid + ", ticketPostId=" + ticketPostId + ", timePosted=" + timePosted
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userImage=" + userImage
				+ ", replies=" + replies + "]";
	}
	
	
	
}
