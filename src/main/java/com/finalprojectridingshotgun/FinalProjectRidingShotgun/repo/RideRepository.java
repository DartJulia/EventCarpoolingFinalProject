package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RideRepository extends JpaRepository<Ride, Long> {

	
	List<Ride> findByEventid(String id);
	List<Ride> findByCityOrRegion(String city, String region);
	List<Ride> findByEventtitleContaining(String eventtitle);
	Ride findEventtitleByRideid(Long rideId);
//	@Query(select * from Ride where city contains?)
//	
//	List<Ride> findCity;
//	Query query = session.createQuery("from Ride where city")
}
