package com.revature.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* All the attributes in the Card class have the same name as the "cards" database table columns, for ease of sending and receiving data */
@Entity
@Table(name = "cards")
public class Card {
	
	@Id//id is set to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-generated
	@Column(name = "card_id")
	private int ticketId;
	
	@Column(name = "ticket_status")
	private int ticketStatus;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "entry_time")
	private Date datePosted;
	
	@Column(name = "date_resolved")
	private Date dateResolved; 
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "admin_id")
	private int admin_id;
	
	
	
	/* Primary Constructor */
	public Card(int ticketId, int ticketStatus, String title, String message, int user_id) {
		super();
		this.ticketId = ticketId;
		this.ticketStatus = ticketStatus;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
        this.datePosted=new Date(System.currentTimeMillis()); //generates a current Date to use as new card's datePosted
		
	}
	
	
	/* Second constructor for Chris's update Ticket model */
	public Card(int ticketId, int ticketStatus, String title, String message, int user_id, int admin_id) {
		super();
		this.ticketId = ticketId;
		this.ticketStatus = ticketStatus;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=admin_id;
		this.dateResolved=new Date(System.currentTimeMillis());	
	}

	
	/* Constructor for new cards */
	//I don't think this is ever actually invoked
	public Card(int ticketStatus, String title, String message, int user_id) {
		super();
		this.ticketStatus = ticketStatus;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=1; //sets admin_id to one because db won't accept zero. 
		this.datePosted=new Date(System.currentTimeMillis());
	}
	
	
	/* Default Constructor */
	public Card() {
		super();
	}
	
	
	
	/* Getters and Setters*/
	//all getters and setters for card class use default behaviors.
	public int getticketId() {
		return ticketId;
	}
	public void setticketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	
	public int getticketStatus() {
		return ticketStatus;
	}
	public void setticketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
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
	
	
	public Date getdatePosted() {
		return datePosted;
	}
	public void setdatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	
	
	public Date getdateResolved() {
		return dateResolved;
	}
	public void setdateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	
	/* ToString method */
	@Override
	public String toString() {
		return "Card [ticketId=" + ticketId + ", ticketStatus=" + ticketStatus + ", title=" + title + ", message=" + message
				+ ", datePosted=" + datePosted + ", user_id=" + user_id + ", admin_id=" + admin_id + "]";
	}

}