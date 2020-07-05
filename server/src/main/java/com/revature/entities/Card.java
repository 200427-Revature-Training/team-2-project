package com.revature.entities;

import java.sql.Date;

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
	private int card_id;
	private int ticket_status;
	private String title;
	private String message;
	private Date entry_time;
	private Date date_resolved; 
	private int user_id;
	private int admin_id;
	
	
	
	/* Primary Constructor */
	public Card(int card_id, int ticket_status, String title, String message, int user_id) {
		super();
		this.card_id = card_id;
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
        this.entry_time=new Date(System.currentTimeMillis()); //generates a current Date to use as new card's entry_time
		
	}
	
	
	/* Second constructor for Chris's update Ticket model */
	public Card(int card_id, int ticket_status, String title, String message, int user_id, int admin_id) {
		super();
		this.card_id = card_id;
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=admin_id;
		this.date_resolved=new Date(System.currentTimeMillis());	
	}

	
	/* Constructor for new cards */
	//I don't think this is ever actually invoked
	public Card(int ticket_status, String title, String message, int user_id) {
		super();
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=1; //sets admin_id to one because db won't accept zero. 
		this.entry_time=new Date(System.currentTimeMillis());
	}
	
	
	/* Default Constructor */
	public Card() {
		super();
	}
	
	
	
	/* Getters and Setters*/
	//all getters and setters for card class use default behaviors.
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	
	
	public int getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(int ticket_status) {
		this.ticket_status = ticket_status;
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
	
	
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	
	
	public Date getDate_resolved() {
		return date_resolved;
	}
	public void setDate_resolved(Date date_resolved) {
		this.date_resolved = date_resolved;
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
		return "Card [card_id=" + card_id + ", ticket_status=" + ticket_status + ", title=" + title + ", message=" + message
				+ ", entry_time=" + entry_time + ", user_id=" + user_id + ", admin_id=" + admin_id + "]";
	}

}