package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {

	
	List<Ride> findByEventtitleContaining(String title);
	
	

}
