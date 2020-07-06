package models;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

public class Card {
	
	@Id//id is set to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-generated
	private int id;
	@OneToMany
	@JoinTable(name="public.ticket_statuses", joinColumns = { @JoinColumn(name="card_id") },
			inverseJoinColumns = { @JoinColumn(name="tid")})//tid was ticket_status_id
	private int ticket_status;
	private String title;
	private String message;
	private String timestamp_posted;
	private String timestamp_resolved;
	private File img; 
	@OneToMany
	@JoinTable(name="public.cards", joinColumns = { @JoinColumn(name="card_id") },//cid=comment_id
			inverseJoinColumns = { @JoinColumn(name="uid")})//uid
	private int user_id;
	@OneToMany
	@JoinTable(name="public.cards", joinColumns = { @JoinColumn(name="card_id") },//cid=comment_id
			inverseJoinColumns = { @JoinColumn(name="uid")})//uid
	private int admin_id;
	
	public Card(int id, int ticket_status, String title, String message, int user_id, File img) {
		super();
		this.id = id;
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=0;
		this.img=img;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=ts;
        this.timestamp_posted=date.toString();//Example:2017-11-02 02:36:57.204
		
	}
	/*
	 * Second constructor for Chris's update Ticket model
	 */
	public Card(int id, int ticket_status, String title, String message, int user_id, int admin_id) {
		super();
		this.id = id;
		this.ticket_status = ticket_status;
		this.title = title;
		this.message = message;
		this.user_id=user_id;
		this.admin_id=admin_id;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=ts;
        this.timestamp_posted=date.toString();//Example:2017-11-02 02:36:57.204
		
	}
	public int getTicket_status() {
		return ticket_status;
	}
	public int getId() {
		return id;
	}
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getTimestamp_posted() {
		return timestamp_posted;
	}
	
	public String getTimestamp_resolved() {
		return timestamp_resolved;
	}
	public void setTimestamp_resolved() {
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=ts;
        this.timestamp_resolved=date.toString();//Example:2017-11-02 02:36:57.204
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public int getUser_id() {
		return user_id;
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
	@Override
	public String toString() {
		return "Card [id=" + id + ", ticket_status=" + ticket_status + ", title=" + title + ", message=" + message
				+ ", timestamp_posted=" + timestamp_posted + ", user_id=" + user_id + ", admin_id=" + admin_id + "]";
	}
	
}