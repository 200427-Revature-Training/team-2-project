package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCrypt;
/**
 * @Entity - Defines that a class can have its persistence managed by a
 *         JPA/Hibernate
 * @Table (optional) - Provide table level configuration
 * @Id - Defines a property as a primary key
 * @GeneratedValue - Configure auto generated value
 * @Column (optional) - Provide column level configuration
 * @Transient - Marks a column to be ignored for persistence
 */	

@Entity
@Table(name = "Users")
public class User {
	
	@Id//id is set to be the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-generated
	private int id;
	private int user_type;
	@Column(unique = true)//sets unique constraint on the column "username"
	private String username;
	private String password;
	private String user_firstname;
	private String user_lastname;
	@Column(unique = true)//sets unique constraint on the column "email"
	private String email;
	private float rating_sigma=0;
	private int times_rated=0;
	private String img;
	private String hash;
	private String salt;
	
	public User(int id, int user_type, String username,String user_firstname,String user_lastname, String password, String email) {
		super();
		this.id=id;
		this.user_type = user_type;
		this.username = username;
		this.user_firstname= user_firstname;
		this.user_lastname=user_lastname;
		this.password = password;
		this.salt=BCrypt.gensalt();
		this.setHash(BCrypt.hashpw(password, salt));
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public String getSalt() {
		return salt;
	}
	public int isUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUser_firstname() {
		return user_firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getRating_sigma() {
		return rating_sigma;
	}
	public int getTimes_rated() {
		return times_rated;
	}
	private float calculate_average(float rateSig, int timesRated) {
		return rateSig/timesRated;
	}
	/*
	 * process for adding and updating the rating for the user
	 */
	public float addRating(int rate) {
		this.rating_sigma+=rate;
		this.times_rated++;
		return calculate_average(this.rating_sigma,this.times_rated);
	}

	@Override
	public String toString() {//omitted the img string
		return "User [id=" + id + ", user_type=" + user_type + ", username=" + username + ", password=" + password
				+ ", user_firstname=" + user_firstname + ", user_lastname=" + user_lastname + ", email=" + email
				+ ", rating_sigma=" + rating_sigma + ", times_rated=" + times_rated + "]";
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
	/*
	 *returns the average user rating calculated via the 
	 *rating_sigma as the numerator and times_rated as the 
	 *denominator 
	 */
}
