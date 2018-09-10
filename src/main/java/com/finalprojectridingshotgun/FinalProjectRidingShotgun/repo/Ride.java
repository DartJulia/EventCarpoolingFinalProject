package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ride_database")
public class Ride {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rideid;
	private String eventid;
	private long userid;
	
	
	
	public Ride() {

	}

	
	
}
