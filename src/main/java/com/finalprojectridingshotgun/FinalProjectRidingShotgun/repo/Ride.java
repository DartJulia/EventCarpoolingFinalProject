package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ride_database")
public class Ride {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rideid;
	private String eventid;
	private long userid;
	private Set<User> users = new HashSet<User>();
	
	
	public Ride() {

	}
	
	public Ride(long rideid, String eventid, long userid, Set<User> users) {
		this.rideid = rideid;
		this.eventid = eventid;
		this.userid = userid;
		this.users = users;
	}

	public Ride(String eventid, long userid, Set<User> users) {
		
		this.eventid = eventid;
		this.userid = userid;
		this.users = users;
	}

	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void deleteUser(User user) {
		this.users.remove(user);
	}
	
	public long getRideid() {
		return rideid;
	}

	public void setRideid(long rideid) {
		this.rideid = rideid;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_ride",
            joinColumns = @JoinColumn(name = "rideid"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
