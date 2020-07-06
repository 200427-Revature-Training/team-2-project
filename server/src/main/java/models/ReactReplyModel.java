package models;

import java.sql.Timestamp;

public class ReactReplyModel {

	

	private int rid;

	private int ticketPostId;

	private Timestamp timestamp;

	private String userFirstName;

	private String userLastName;

	private String userImage;

	private String replies;

	

	

	

	public int getRid() {

		return rid;

	}

	public void setRid(int rid) {

		this.rid = rid;

	}

	public int getTicketPostId() {

		return ticketPostId;

	}

	public void setTicketPostId(int ticketPostId) {

		this.ticketPostId = ticketPostId;

	}

	public Timestamp getTimestamp() {

		return timestamp;

	}

	public void setTimestamp(Timestamp timestamp) {

		this.timestamp = timestamp;

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

	public String getReplies() {

		return replies;

	}

	public void setReplies(String replies) {

		this.replies = replies;

	}

	@Override

	public String toString() {

		return "ReactReplyModel [rid=" + rid + ", ticketPostId=" + ticketPostId + ", timestamp=" + timestamp

				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userImage=" + userImage

				+ ", replies=" + replies + "]";

	}

	public ReactReplyModel(int rid, int ticketPostId, Timestamp timestamp, String userFirstName, String userLastName,

			String userImage, String replies) {

		super();

		this.rid = rid;

		this.ticketPostId = ticketPostId;

		this.timestamp = timestamp;

		this.userFirstName = userFirstName;

		this.userLastName = userLastName;

		this.userImage = userImage;

		this.replies = replies;

	}

	public ReactReplyModel() {

		super();

		// TODO Auto-generated constructor stub

	}	

}

