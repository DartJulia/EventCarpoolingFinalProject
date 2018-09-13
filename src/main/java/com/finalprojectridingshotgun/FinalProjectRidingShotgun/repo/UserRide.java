package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_ride")
public class UserRide {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_ride_id;
	/**
	 * 
	 */

	/**
	 * 
	 */

	
	@JoinColumn(foreignKey = @ForeignKey (name = "user_id"))
	private Long user_id;
	
	@JoinColumn(foreignKey = @ForeignKey (name = "ride_id"))
	private Long ride_id;

	public UserRide() {

	}

	public UserRide(Long user_id, Long ride_id) {
		super();
		this.user_id = user_id;
		this.ride_id = ride_id;
	}

	public Long getUserid() {
		return user_id;
	}

	public void setUserid(Long user_id) {
		this.user_id = user_id;
	}

	public Long getRideid() {
		return ride_id;
	}

	public void setRideid(Long ride_id) {
		this.ride_id = ride_id;
	}

	@Override
	public String toString() {
		return "UserRide [userid=" + user_id + ", rideid=" + ride_id + "]";
	}

}
