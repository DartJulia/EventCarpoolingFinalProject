package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ride_id")
	private Long rideid;
	@Column(name = "eventid")
	private String eventid;
	@Column(name = "eventtitle")
	private String eventtitle;
	@Column(name = "user_id")
	private Long userid;
	@Column(name = "city_name")
	private String city;
	@Column(name = "region_name")
	private String region;
	//ownerside
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_ride", joinColumns = @JoinColumn(name = "ride_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new ArrayList<User>();
	
	
	public Ride() {

	}
	
	public Ride(String id, String eventtitle, Long userid) {
		this.eventid = id;
		this.eventtitle = eventtitle;
		this.userid = userid;
	}

	public Ride(Long rideid, String eventid, Long userid, List<User> users) {
		this.rideid = rideid;
		this.eventid = eventid;
		this.userid = userid;
		this.users = users;
	}

	public Ride(String eventid, Long userid, List<User> users) {
		
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

	public Long getRideid() {
		return rideid;
	}

	public void setRideid(Long rideid) {
		this.rideid = rideid;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	

	public String getEventtitle() {
		return eventtitle;
	}

	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Ride [rideid=" + rideid + ", eventid=" + eventid + ", eventtitle=" + eventtitle + ", userid=" + userid
				+ ", users=" + users + "]";
	}

}
