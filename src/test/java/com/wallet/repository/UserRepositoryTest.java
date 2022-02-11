package com.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository repository;
	
	@BeforeEach
	public void setUp() {
		
		User u = new User();
		u.setName("Set Up User");
		u.setPassword("123");
		u.setEmail(EMAIL);
		repository.save(u);
		
	}
	
	@AfterEach
	public void tearDown() {
		
		repository.deleteAll();
		
	}
	
	
	@Test
	public void testSave( ) {
		
		User u = new User();
		u.setName("Teste");
		u.setPassword("123456");
		u.setEmail("teste@teste.com");
		
		User response = repository.save(u);
		
		assertNotNull(response);
		
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
	

}
