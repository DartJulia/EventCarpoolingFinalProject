package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RideRepository extends JpaRepository<Ride, Long> {

	
	List<Ride> findByEventid(String id);

//	List<Ride> findByCityOrRegion(String city, String region);

	List<Ride> findByEventtitleContaining(String query);

	List<Ride> findByCityContaining(String query);

	List<Ride> findByRegion(String query);
	
	// should work, maybe try an @Query
//	List<Ride> findByEventtitleContainingAndCityAndRegion(String eventtitle, String city, String region);
	
//	@Query(value = "select * from ride_database where eventtitle ='" + searchTerm +"'", nativeQuery = true)
//	List<Ride> findContaining(String searchTerm);
//  @Param("searchTerm") String searchTerm
	
	Ride findEventtitleByRideid(Long rideId);

	Ride findLatitudeByRideid(Long rideId);

	Ride findLongitudeByRideid(Long rideId);
//
//	List<Ride> findUserIdByCityOrRegion(String city, String region);

}
