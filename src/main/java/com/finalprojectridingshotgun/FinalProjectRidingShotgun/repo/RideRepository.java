package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RideRepository extends JpaRepository<Ride, Long> {

	
	List<Ride> findByEventid(String id);

	List<Ride> findByCityOrRegion(String city, String region);

	List<Ride> findByEventtitleContaining(String eventtitle);
	
	// should work, maybe try an @Query
	List<Ride> findByEventtitleContainingOrCityOrRegion(String eventtitle, String city, String region);
	
//	@Query(value = "select * from ride_database where eventtitle ='" + searchTerm +"'", nativeQuery = true)
//	List<Ride> findContaining(@Param("searchTerm") String searchTerm);
	
	
	Ride findEventtitleByRideid(Long rideId);

	Ride findLatitudeByRideid(Long rideId);

	Ride findLongitudeByRideid(Long rideId);

	List<Ride> findUserIdByCityOrRegion(String city, String region);

}
