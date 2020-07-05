package com.revature.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


//all Reply class properties have the same names as the "replies" database table columns for ease and simplicity of db access.
@Entity
@Table(name = "replies")
public class Reply {
	@Id//id is set to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-generated
	@Column(name="rid")
	private int rid;
	
	@Column(name="tpid")
	private int ticketPostId;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="replies")
	private String replies;
	
	@Column(name="entry_time")
	private Date timestamp;
	
	
	/* Primary Constructor */
	public Reply(int rid, int ticketPostId, int user_id,String replies) {
		super();
		this.ticketPostId = ticketPostId;
		this.rid=rid;
		this.user_id=user_id;
		this.replies=replies;
		//not sure why this constructor this method for the Date when the other classes don't, but I'll leave it unless it causes problems.
		Date ts=new Date(System.currentTimeMillis());
		Date date=ts;
        this.timestamp=ts;//Example:2017-11-02 02:36:57.204 
        }

	/* Default Constructor */
	public Reply() {
		super();
	}
	
	
	
	/* Getters and Setters */
	//All have default behavior, unused setters haven't been created.
	
	public int getRid() {
		return rid;
	}
	
	
	public int getCard_id() {
		return ticketPostId;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	
	
	public Date gettimestamp() {
		return timestamp;
	}
	
	
	public String getReplies() {
		return replies;
	}
	public void setReplies(String replies) {
		this.replies = replies;
	}
	
	
	
	/* ToString Method */
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", ticketPostId=" + ticketPostId + ", user_id=" + user_id + ", replies=" + replies + "]";
	}
	
}
