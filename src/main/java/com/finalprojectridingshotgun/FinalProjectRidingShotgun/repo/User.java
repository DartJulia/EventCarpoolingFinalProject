package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_database")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "username")
	private String username;
	@Column(name = "passcode")
	private String passcode;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "car_type")
	private String car_type;
	@Column(name = "seats")
	private Integer seats;
	@Column(name = "plate")
	private String plate;

	@ManyToMany(mappedBy = "users")
	private List<Ride> ride = new ArrayList<Ride>();

	public User() {

	}

	public User(Long user_id, String first_name, String last_name, String username, String passcode, String address,
			String email, String car_type, Integer seats, String plate) {
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.passcode = passcode;
		this.address = address;
		this.email = email;
		this.car_type = car_type;
		this.seats = seats;
		this.plate = plate;
	}

	public User(String first_name, String last_name, String username, String passcode, String address, String email,
			String car_type, Integer seats, String plate) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.passcode = passcode;
		this.address = address;
		this.email = email;
		this.car_type = car_type;
		this.seats = seats;
		this.plate = plate;
	}

	public User(String first_name, String last_name, String username, String passcode, String address, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.passcode = passcode;
		this.address = address;
		this.email = email;

	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public List<Ride> getRide() {
		return ride;
	}

	public void setRide(List<Ride> ride) {
		this.ride = ride;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", passcode=" + passcode + ", address=" + address + ", email=" + email + ", car_type="
				+ car_type + ", seats=" + seats + ", plate=" + plate + "]";
	}

}
