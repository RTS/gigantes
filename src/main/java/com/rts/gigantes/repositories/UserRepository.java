package com.rts.gigantes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.gigantes.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByLogin(String login);

}