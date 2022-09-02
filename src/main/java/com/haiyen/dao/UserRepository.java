package com.haiyen.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.haiyen.model.*;


public interface UserRepository extends JpaRepository<User, Integer> {
	public Long countByid(Integer id);
	public Optional<User> findUserByEmail(String email);

}
