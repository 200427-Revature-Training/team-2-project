package entities;

import java.sql.Timestamp;
import java.util.Date;

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
	private int rid;
	private int tpid;
	private int user_id;
	private String replies;
	private Timestamp entry_time;

	/* Primary Constructor */
	public Reply(int rid, int tpid, int user_id,String replies) {
		super();
		this.tpid = tpid;
		this.rid=rid;
		this.user_id=user_id;
		this.replies=replies;
		//not sure why this constructor this method for the timestamp when the other classes don't, but I'll leave it unless it causes problems.
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=ts;
        this.entry_time=ts;//Example:2017-11-02 02:36:57.204 
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
		return tpid;
	}
	public int getUser_id() {
		return user_id;
	}
	public Timestamp getEntry_time() {
		return entry_time;
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
		return "Reply [rid=" + rid + ", tpid=" + tpid + ", user_id=" + user_id + ", replies=" + replies + "]";
	}
}

