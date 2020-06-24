package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testAddRating() {
		//fail("Not yet implemented");
		User user=new User(0,0,"Wu-Tang","is","for","the","kids");
		float rating=user.addRating(5);
		rating=user.addRating(4);
		rating=user.addRating(5);
		rating=user.addRating(2);
		rating=user.addRating(1);
		rating=user.addRating(3);
		rating=user.addRating(1);
		rating=user.addRating(5);
		rating=user.addRating(4);
///judges the float returned by the function with 10/3. with an acceptable delta of .00001
		assertEquals(rating,10/3.,.00001);
//checking if the associated variables of the method were saved correctly
		assertEquals(user.getRating_sigma(),30,0);
		assertEquals(user.getTimes_rated(),9,0);
		
	}
	

}
