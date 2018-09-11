package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_ride")
public class UserRide implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "user_id")
	private long user_id;
	@Id
	@Column(name = "ride_id")
	private long ride_id;

	public UserRide() {

	}

	public UserRide(long user_id, long ride_id) {
		super();
		this.user_id = user_id;
		this.ride_id = ride_id;
	}

	public long getUserid() {
		return user_id;
	}

	public void setUserid(long user_id) {
		this.user_id = user_id;
	}

	public long getRideid() {
		return ride_id;
	}

	public void setRideid(long ride_id) {
		this.ride_id = ride_id;
	}

	@Override
	public String toString() {
		return "UserRide [userid=" + user_id + ", rideid=" + ride_id + "]";
	}

}
