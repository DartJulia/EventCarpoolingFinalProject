package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsernameAndPasscode (String user_name, String passcode);
//	Integer findSeatsByUser__id(Long id);
//	String findFirst__nameByUser__id(Long userId);

}
