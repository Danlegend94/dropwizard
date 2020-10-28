package com.corso.dropwizard.udemy.dropbookamrksprova.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.testing.junit.ResourceTestRule;


//TODO RIVEDI CLASSE DI TEST
public class UserResourceTest {

	private static HttpAuthenticationFeature FEATURE = HttpAuthenticationFeature.basic("username", "password");

	public static final Authenticator<BasicCredentials, User> SECURITYRULE = new Authenticator<BasicCredentials, User>() {

		@Override
		public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
			return Optional.of(new User());
		}
	};

	@ClassRule
	public static final ResourceTestRule RULE = new ResourceTestRule.Builder()
			.addProvider(AuthFactory.binder(new BasicAuthFactory<>(SECURITYRULE, "Security", User.class)))
			.addResource(new UserResources())
			.setTestContainerFactory(new GrizzlyWebTestContainerFactory())
			.build();

	@Test
	public void HelloResource() {
		String expected = "Hello world";
		String actual = RULE.getJerseyTest().target("/hello").request(MediaType.TEXT_PLAIN_TYPE).get(String.class);
		assertEquals(expected, actual);
	}

	@Test
	public void HelloResourceSecurity() {
		String expected = "Hello world security";
		String actual = RULE.getJerseyTest().target("/hello/security").request(MediaType.TEXT_PLAIN_TYPE)
				.get(String.class);
		assertEquals(expected, actual);
	}
	
	@BeforeClass
	public static void setUpClass() {
		RULE.getJerseyTest().client().register(FEATURE);
	}

}
