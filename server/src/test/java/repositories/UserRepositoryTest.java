package repositories;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import entities.User;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {Application.class})
//@ComponentScan("repositories.UserRepository")
public class UserRepositoryTest {
	@Autowired
	@InjectMocks
	UserRepository userRepo=new UserRepository();
	//@MockBean
	@Mock
	EntityManager em;
	//@MockBean
	@Mock
	Session session;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		//userRepo = Mockito.mock(UserRepository.class);
		//userRepo=new UserRepository();
		
	}
	@Test
	public void testUserSave() {
		User user=new User(0,0,"Wu-Tang","is","for","the","kids");
		when(em.unwrap(Session.class)).thenReturn(session);
		when(session.get(User.class,user.getUsername())).thenReturn(null);
		when(session.get(User.class,user.getEmail())).thenReturn(null);
		User check= userRepo.save(user);
		assertEquals(user, check);
	}
	
	/*@Test
	public void testDuplicateUsernameUserSave() {//testing bean constraints
		User usernameRepeat=new User(0,0,"Wu-Tang","is","for","the","kids");
		when(em.unwrap(Session.class)).thenReturn(session);
		when(session.get(User.class,usernameRepeat.getUsername())).thenReturn(usernameRepeat);
		when(session.get(User.class,usernameRepeat.getEmail())).thenReturn(null);
		usernameRepeat=userRepo.save(usernameRepeat);
		assertEquals(usernameRepeat, null);
	}
	
	@Test
	public void testDuplicateEmailUserSave() {//testing bean constraints
		User emailRepeat=new User(0,0,"Wu-Tang","is","for","the","kids");
		when(em.unwrap(Session.class)).thenReturn(session);
		when(session.get(User.class,emailRepeat.getUsername())).thenReturn(null);
		when(session.get(User.class,emailRepeat.getEmail())).thenReturn(emailRepeat);
		emailRepeat=userRepo.save(emailRepeat);
		assertEquals(emailRepeat, null);
	}*/
	
	@Test
	public void testUserUpdate() {//testing bean constraints
		User user=new User(0,0,"Wu-Tang","is","for","the","kids");
		when(em.unwrap(Session.class)).thenReturn(session);
		//when(session.get(User.class,user.getUsername())).thenReturn(null);
		//when(session.get(User.class,user.getEmail())).thenReturn(null);
		User update=userRepo.update(user);
		assertEquals(user, update);
	}
		
	@Test
	public void testLogin() {
		User user=new User(0,0,"Wu-Tang","is","for","the","kids");
		int uid=user.getUid();
		when(em.unwrap(Session.class)).thenReturn(session);
		when(session.get(User.class, uid)).thenReturn(user);
		User log=userRepo.login(0, "the");
		System.out.println(log);
		assertEquals(log, user);
	}
}
