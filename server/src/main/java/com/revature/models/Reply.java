package com.revature.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "replies")
public class Reply {
	@Id//id is set to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-generated
	private int rid;
//	@OneToMany
//	@JoinTable(name="public.replies", joinColumns = { @JoinColumn(name="cid") },//cid=comment_id
//			inverseJoinColumns = { @JoinColumn(name="tpid")})//tpid replaced post_id
	private int tpid;
//	@OneToMany
//	@JoinTable(name="public.replies", joinColumns = { @JoinColumn(name="cid") },//cid=comment_id
//			inverseJoinColumns = { @JoinColumn(name="uid")})//uid
	private int user_id;
	private String replies;
	private String entry_time;
	
	public Reply(int rid, int tpid, int user_id,String replies) {
		super();
		this.tpid = tpid;
		this.rid=rid;
		this.user_id=user_id;
		this.replies=replies;
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=ts;
        this.entry_time=date.toString();//Example:2017-11-02 02:36:57.204
	}
	public int getPost_id() {
		return tpid;
	}
	
	public int getRid() {
		return rid;
	}
	public int getCard_id() {
		return tpid;
	}
	public int getUser_id() {
		return user_id;
	}
	
	public String getEntry_time() {
		return entry_time;
	}
	
	public String getReplies() {
		return replies;
	}
	public void setReplies(String replies) {
		this.replies = replies;
	}
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", tpid=" + tpid + ", user_id=" + user_id + ", replies=" + replies + "]";
	}
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
