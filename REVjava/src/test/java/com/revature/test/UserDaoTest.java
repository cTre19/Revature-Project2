package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;

public class UserDaoTest {

	private UserDao udao;
	private User newUser, newUser2, newUser3;
	private List<User> users;

	@Mock
	private Session sess;
	@Mock
	private Transaction tx;
	@Mock
	private Query query;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		users = new ArrayList<>();

		newUser = new User();
		newUser.setFirstName("Matt");
		newUser.setLastName("McFall");
		newUser.setEmail("mm@rev.com");
		newUser.setPassword("rules");
		newUser.setCity("Tampa");
		newUser.setState("Florida");
		newUser.setPosition("Trainee");
		newUser.setBatchId(7);
		newUser.setClientCompany("Cognizant");
		newUser.setId(123);
		users.add(newUser);

		newUser2 = new User();
		newUser2.setFirstName("Justin");
		newUser2.setLastName("Donn");
		newUser2.setEmail("jd@rev.com");
		newUser2.setPassword("ice");
		newUser2.setCity("Tampa");
		newUser2.setState("Florida");
		newUser2.setPosition("Trainee");
		newUser2.setBatchId(7);
		newUser2.setClientCompany("Cognizant");
		newUser2.setId(124);
		users.add(newUser2);
		
		newUser3 = new User();
		newUser3.setFirstName("Some");
		newUser3.setLastName("Guy");
		newUser3.setEmail("sg@rev.com");
		newUser3.setPassword("thick");
		newUser3.setCity("Dallas");
		newUser3.setState("Texas");
		newUser3.setPosition("Developer");
		newUser3.setBatchId(63);
		newUser3.setClientCompany("Verizon");
		newUser3.setId(666);
		users.add(newUser3);
		
		udao = new UserDaoImpl();
		udao.setCurrentSession(sess);
		(Mockito.doReturn(newUser).when(sess)).get(User.class, newUser.getEmail());
		(Mockito.doReturn(newUser2).when(sess)).get(User.class, newUser2.getEmail());
		(Mockito.doReturn(newUser3).when(sess)).get(User.class, newUser3.getEmail());
		(Mockito.doReturn(query).when(sess)).createQuery("FROM revuser");
		(Mockito.doReturn(users).when(query)).getResultList();
		(Mockito.doReturn(tx).when(sess)).beginTransaction();

	}

	@After
	public void tearDown() throws Exception {
		users.clear();
		udao = null;
		newUser = null;
		newUser2 = null;
		newUser3 = null;
	}

	@Test
	public void getUserTest() {
		System.out.println(newUser);
		User result = udao.getUser(newUser.getEmail());
		assertEquals(newUser.getEmail(), result.getEmail());
		assertEquals(newUser.getFirstName(), result.getFirstName());
		assertEquals(newUser.getLastName(), result.getLastName());
		assertEquals(newUser.getPassword(), result.getPassword());
		assertEquals(newUser.getCity(), result.getCity());
		assertEquals(newUser.getState(), result.getState());
		assertEquals(newUser.getPosition(), result.getPosition());
		assertEquals(newUser.getBatchId(), result.getBatchId());
		assertEquals(newUser.getClientCompany(), result.getClientCompany());
		assertEquals(newUser.getId(), result.getId());
		
	}

}
