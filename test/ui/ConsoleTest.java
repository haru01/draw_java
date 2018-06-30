package ui;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import ui.Command;
import ui.Console;

public class ConsoleTest {

	@Test
	public void testOneLine() {
		String input = "text (60, 80, \"2018年6月27日\\n森に行った。(vol1,1)\", 12); ";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		
		Console con = new Console(in);
		Command cmd = con.readCommand();
		
		assertTrue(cmd.is("text"));
	}


	@Test
	public void testMultiLine() {
		String input = "group(\n" 
				+ "  text (60, 80, \"2018年6月27日\\n森に行った。(vol1,1)\", 12), \n"
				+ "  image (80, 150, 100, 50, \"https://eiwasec.files.wordpress.com/2018/06/img64_64.png\") \n"
				+");";
		
		InputStream in = new ByteArrayInputStream(input.getBytes());
		
		Console con = new Console(in);
		Command cmd = con.readCommand();
		
		assertTrue(cmd.is("group"));
	}
}
