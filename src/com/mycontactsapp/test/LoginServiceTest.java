package com.mycontactsapp.test;
import com.mycontactsapp.model.FreeUser;
import com.mycontactsapp.auth.*;
import com.mycontactsapp.model.*;
import com.mycontactsapp.service.*;
import org.junit.jupiter.api.Test;
import com.mycontactsapp.repository.*;
import com.mycontactsapp.util.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {

	@Test
	void testSuccessfulLogin() {

	    User user = new FreeUser(
	            "sindhur@gmail.com",
	            PasswordUtil.hashPassword("123"),
	            "Sindhur"
	    );

	    UserRepository.save(user);

	    LoginService service =
	            new LoginService(new BasicAuth());

	    Optional<User> result =
	            service.login("sindhur@gmail.com", "123");

	    assertTrue(result.isPresent());
	}


    @Test
    void testInvalidPassword() {

        LoginService service =
                new LoginService(new BasicAuth());

        Optional<User> result =
                service.login("sindhur@gmail.com","123");

        assertTrue(result.isEmpty());
    }
}