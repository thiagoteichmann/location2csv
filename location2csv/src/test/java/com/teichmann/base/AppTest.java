package com.teichmann.base;

import org.junit.Test;

public class AppTest {

	public void testAppWithNull() {
		App.main(null);
	
	}
	
	public void testAppWithEmpty() {
		App.main(new String[]{});
	}
	
	@Test
	public void testAppWithValidName() {
		App.main(new String[]{"Bremen"});
	}

}
