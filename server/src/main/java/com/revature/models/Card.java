package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {
	
	@Id//id is set to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-generated
	private int card_id;
//	@OneToMany
//	@JoinTable(name="public.ticket_statuses", joinColumns = { @JoinColumn(name="card_id") },
//			inverseJoinColumns = { @JoinColumn(name="tid")})//tid was ticket_status_id
	private int ticket_status;
	private String title;
	private String message;
	private Timestamp entry_time;
	private Timestamp date_resolved;
//	private File img; 
//	@OneToMany
//	@JoinTable(name="public.cards", joinColumns = { @JoinColumn(name="card_id") },//cid=comment_id
//			inverseJoinColumns = { @JoinColumn(name="uid")})//uid
	private int user_id;
//	@OneToMany
//	@JoinTable(name="public.cards", joinColumns = { @JoinColumn(name="card_id") },//cid=comment_id
//			inverseJoinColumns = { @JoinColumn(name="uid")})//uid
	private int admin_id;
	
	public Card(int card_id, int ticket_status, String title, String message, int user_id) {
		super();
		this.card_id = card_id;
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
//		this.img=img;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
//		Date date=ts;
        this.entry_time=ts;//.toString();//Example:2017-11-02 02:36:57.204
		
        System.out.println("primary constructor invoked");
	}
	/*
	 * Second constructor for Chris's update Ticket model
	 */
	public Card(int card_id, int ticket_status, String title, String message, int user_id, int admin_id) {
		super();
		this.card_id = card_id;
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=admin_id;
		this.date_resolved=new Timestamp(System.currentTimeMillis());
//		Date date=ts;
//        this.entry_time=date.toString();//Example:2017-11-02 02:36:57.204
		
		System.out.println("ticket update constructor invoked");
		
	}

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
	public Timestamp getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Timestamp entry_time) {
		this.entry_time = entry_time;
	}
	public Timestamp getDate_resolved() {
		return date_resolved;
	}
	public void setDate_resolved(Timestamp date_resolved) {
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
	
	
	@Override
	public String toString() {
		return "Card [card_id=" + card_id + ", ticket_status=" + ticket_status + ", title=" + title + ", message=" + message
				+ ", entry_time=" + entry_time + ", user_id=" + user_id + ", admin_id=" + admin_id + "]";
	}
	
	//constructor for new cards
	public Card(int ticket_status, String title, String message, int user_id) {
		super();
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=1;
//		this.img=img;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
//		Date date=ts;
        this.entry_time=ts;//.toString();//Example:2017-11-02 02:36:57.204
        
        System.out.println("new card constructor invoked");
        
	}
	
	public Card() {
		super();
		System.out.println("default constructor invoked");
	}


}