package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthenticationResponseTest {

	@Test
	void test() {
		AuthenticationResponse ar=new AuthenticationResponse("ar");
		assertEquals(ar.getJwt(),"ar");
	}

}
