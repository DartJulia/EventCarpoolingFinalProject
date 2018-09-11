package com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsernameAndPasscode (String user_name, String passcode);

}
