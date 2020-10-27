package com.corso.dropwizard.udemy.dropbookamrksprova.resources;


import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;
import io.dropwizard.testing.junit.ResourceTestRule;

public class HelloResourceTest {
	
	@ClassRule
	public static final ResourceTestRule RULE = new ResourceTestRule.Builder().addResource(new HelloResources()).build();
	
	@Test
	public void HelloResource() {
		String expected = "Hello world";
		String actual = RULE.getJerseyTest().target("/hello").request(MediaType.TEXT_PLAIN_TYPE).get(String.class);
		assertEquals(expected, actual);
	}

}
