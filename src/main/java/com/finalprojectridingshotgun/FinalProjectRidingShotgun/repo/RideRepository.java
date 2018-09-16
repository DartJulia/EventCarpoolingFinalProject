package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RideRepository extends JpaRepository<Ride, Long> {

	
	List<Ride> findByEventid(String id);

	List<Ride> findByCityOrRegion(String city, String region);

	List<Ride> findByEventtitleContaining(String eventtitle);

	Ride findEventtitleByRideid(Long rideId);

	Ride findLatitudeByRideid(Long rideId);

	Ride findLongitudeByRideid(Long rideId);

}
