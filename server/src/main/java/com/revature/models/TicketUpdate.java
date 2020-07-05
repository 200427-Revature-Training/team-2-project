package com.revature.models;

import java.sql.Date;
import java.sql.Date;

public class TicketUpdate {
	private int ticketId;
	private String title;
	private Date dateResolved;
	private String userFirstName;
	private String userLastName;
	private String message;
	private int ticketStatus;
	private String adminUsername;
		
	public TicketUpdate(int ticketId, String title, Date dateResolved, String userFirstName, String userLastName,
			String message, int ticketStatus, String adminUsername) {
		super();
		this.ticketId = ticketId;
		this.title = title;
		this.dateResolved = dateResolved;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.message = message;
		this.ticketStatus = ticketStatus;
		this.adminUsername = adminUsername;
	}
	
	
	public TicketUpdate() {
		super();
	}
	
	
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateResolved() {
		return dateResolved;
	}
	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminUsername == null) ? 0 : adminUsername.hashCode());
		result = prime * result + ((dateResolved == null) ? 0 : dateResolved.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ticketId;
		result = prime * result + ticketStatus;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
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
		TicketUpdate other = (TicketUpdate) obj;
		if (adminUsername == null) {
			if (other.adminUsername != null)
				return false;
		} else if (!adminUsername.equals(other.adminUsername))
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
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TicketUpdate [ticketId=" + ticketId + ", title=" + title + ", dateResolved=" + dateResolved
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", message=" + message
				+ ", ticketStatus=" + ticketStatus + ", adminUsername=" + adminUsername + "]";
	}
	
	
	
}
