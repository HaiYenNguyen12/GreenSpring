package com.haiyen.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.haiyen.dao.UserRepository;
import com.haiyen.model.User;


@Service
public class UserService {
	@Autowired private UserRepository repo;
	
	
		public List<User> listAll () {
		return (List<User>) repo.findAll();
		}
		
		public void save(User user)  {
			 repo.save(user);
		}
	    
		public User get(int id) throws UserNotFoundException {
			
			Optional<User> result = repo.findById(id);
			if(result.isPresent()) {
				return result.get();
			}
			else {
				throw new UserNotFoundException("Could not found any user with this Id" + id);
			}
		}
		
		public void delete(int id) throws UserNotFoundException {
			
			Long count = repo.countByid(id);
			if (count == null | count == 0) {
				throw new UserNotFoundException("Could not found any user with this Id" + id);
			}
			else {
			repo.deleteById(id);
			}
		}
	

}
