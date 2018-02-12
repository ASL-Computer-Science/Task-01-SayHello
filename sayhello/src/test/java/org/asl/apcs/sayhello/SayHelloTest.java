package org.asl.apcs.sayhello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SayHelloTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@AfterEach
	public void restoreStreams() {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}

	@Test
	void testMain() {
	    SayHello.main(new String[] {});
	    String s = outContent.toString().trim();
	    assertEquals(", ", s.substring(5, 7), "Did you remember a comma and space?");
	    assertEquals("hello, world!", s.toLowerCase(), "Did you spell the phrase correctly?");
	    assertEquals("Hello, world!", s, "Are you certain of your capitalization?");
	}

}
