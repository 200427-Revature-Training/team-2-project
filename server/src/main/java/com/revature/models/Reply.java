package com.revature.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

public class Reply {
	@Id//id is set to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-generated
	private int rid;
	@OneToMany
	@JoinTable(name="public.replies", joinColumns = { @JoinColumn(name="cid") },//cid=comment_id
			inverseJoinColumns = { @JoinColumn(name="card_id")})//card_id replaced post_id
	private int card_id;
	@OneToMany
	@JoinTable(name="public.replies", joinColumns = { @JoinColumn(name="cid") },//cid=comment_id
			inverseJoinColumns = { @JoinColumn(name="uid")})//uid
	private int user_id;
	private String replies;
	private String timestamp_posted;
	
	public Reply(int rid, int card_id, int user_id,String replies) {
		super();
		this.card_id = card_id;
		this.rid=rid;
		this.user_id=user_id;
		this.replies=replies;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=ts;
        this.timestamp_posted=date.toString();//Example:2017-11-02 02:36:57.204
	}
	public int getPost_id() {
		return card_id;
	}
	
	public int getRid() {
		return rid;
	}
	public int getCard_id() {
		return card_id;
	}
	public int getUser_id() {
		return user_id;
	}
	
	public String getTimestamp_posted() {
		return timestamp_posted;
	}
	
	public String getReplies() {
		return replies;
	}
	public void setReplies(String replies) {
		this.replies = replies;
	}
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", card_id=" + card_id + ", user_id=" + user_id + ", replies=" + replies + "]";
	}
	
}
