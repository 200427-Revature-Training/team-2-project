package com.revature.models;

public class ReactUserModel {

	private String userImage;
	private String username;
	private String userRole;
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userImage == null) ? 0 : userImage.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ReactUserModel other = (ReactUserModel) obj;
		if (userImage == null) {
			if (other.userImage != null)
				return false;
		} else if (!userImage.equals(other.userImage))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReactUserModel [userImage=" + userImage + ", username=" + username + ", userRole=" + userRole + "]";
	}
	public ReactUserModel(String userImage, String username, String userRole) {
		super();
		this.userImage = userImage;
		this.username = username;
		this.userRole = userRole;
	}
	public ReactUserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}