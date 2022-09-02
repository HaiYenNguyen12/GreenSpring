package com.haiyen;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.haiyen.dao.UserRepository;
import com.haiyen.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired private UserRepository repo;
	
	@Test
	public void testAddNew() {
		User user = new User();
		user.setEmail("girlmilk1234@gmail.com");
		user.setFirstname("Nguyen");
		user.setLastname("Yennnnn");
		user.setPassword("123456");
		
		User saved_user = repo.save(user);
		Assertions.assertThat(saved_user).isNotNull();
		Assertions.assertThat(saved_user.getId()).isGreaterThan(0);
	}
	
	
	@Test
	public void testGetAll() {
		Iterable<User> list = repo.findAll();
		Assertions.assertThat(list).hasSizeGreaterThan(0);
		
	}
	
	
	@Test
	public void testUPdate() {
		Integer id = 1;
		Optional<User> update_user = repo.findById(id);
		
		User updated = update_user.get();
		updated.setPassword("helohelo");
		repo.save(updated);
		Optional<User> updated_user = repo.findById(id);
		Assertions.assertThat(updated_user.get().getPassword()).isEqualTo("helohelo");
		
	}
	
	@Test
	public void testGet() {
		Integer id = 1;
		Optional<User> update_user = repo.findById(id);
		
	
		Assertions.assertThat(update_user).isPresent();
		System.out.println(update_user.get());
		
	}
	
	
	@Test
	public void testDelete() {
		Integer id = 1;
	
		
		repo.deleteById(id);
		
		Optional<User> update_user = repo.findById(id);
		
		
		Assertions.assertThat(update_user).isEmpty();
		
	}
	
	

}
