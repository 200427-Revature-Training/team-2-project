package com.revature.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "react_ticket")
public class ReactCard {
	
	@Id
	@Column(name="ticket_id")
	private int ticketId;
	
	@Column(name="ticket_status")
	private int ticketStatus;
	
	@Column(name="user_first_name")
	private String userFirstName;
	
	@Column(name="user_last_name")
	private String userLastName;
	
	@Column
	private String userName;
	
	@Column(name="user_image")
	private String userImage;
	
	@Column(name="admin_first_name")
	private String adminFirstName;
	
	@Column(name="admin_last_name")
	private String adminLastName;
	
	@Column(name="date_posted")
	private Date datePosted;
	
	@Column(name="date_resolved")
	private Date dateResolved;
	
	@Column(name="title")
	private String title;
	
	@Column(name="message")
	private String message;
	
	
	public ReactCard(int ticketId, int ticketStatus, String userFirstName, String userLastName, String userImage,
			String adminFirstName, String adminLastName, Date datePosted, Date dateResolved, String title,
			String message) {
		super();
		this.ticketId = ticketId;
		this.ticketStatus = ticketStatus;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userImage = userImage;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.datePosted = datePosted;
		this.dateResolved = dateResolved;
		this.title = title;
		this.message = message;
	}
	
	public ReactCard() {
		super();

		
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
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
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	public Date getDateResolved() {
		return dateResolved;
	}
	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
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
		result = prime * result + ((adminFirstName == null) ? 0 : adminFirstName.hashCode());
		result = prime * result + ((adminLastName == null) ? 0 : adminLastName.hashCode());
		result = prime * result + ((datePosted == null) ? 0 : datePosted.hashCode());
		result = prime * result + ((dateResolved == null) ? 0 : dateResolved.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ticketId;
		result = prime * result + ticketStatus;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ReactCard other = (ReactCard) obj;
		if (adminFirstName == null) {
			if (other.adminFirstName != null)
				return false;
		} else if (!adminFirstName.equals(other.adminFirstName))
			return false;
		if (adminLastName == null) {
			if (other.adminLastName != null)
				return false;
		} else if (!adminLastName.equals(other.adminLastName))
			return false;
		if (datePosted == null) {
			if (other.datePosted != null)
				return false;
		} else if (!datePosted.equals(other.datePosted))
			return false;
		if (dateResolved == null) {
			if (other.dateResolved != null)
				return false;
		} else if (!dateResolved.equals(other.dateResolved))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (ticketId != other.ticketId)
			return false;
		if (ticketStatus != other.ticketStatus)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "ReactCard [ticketId=" + ticketId + ", ticketStatus=" + ticketStatus + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userImage=" + userImage + ", adminFirstName=" + adminFirstName
				+ ", adminLastName=" + adminLastName + ", datePosted=" + datePosted + ", dateResolved=" + dateResolved
				+ ", title=" + title + ", message=" + message + "]";
	}
	
	
	
}