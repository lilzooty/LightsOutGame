import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the LightsOutButton class.
 * 
 * @author Prof. Martin and Nicholas Kroop
 * @version 4-9-2023
 */
public class LightsOutButtonTest {
	
	@Test
	public void testGetRow() {
		LightsOutButton button = new LightsOutButton(3, 4);
		assertEquals(3, button.getRow());
	}
	
	@Test
	public void testGetColumn() {
		LightsOutButton button = new LightsOutButton(3, 4);
		assertEquals(4, button.getColumn());
		LightsOutButton button2 = new LightsOutButton(0,0);
		assertEquals(0, button2.getColumn());
	}
	
	
	@Test
	public void testIsOn() {
		LightsOutButton button = new LightsOutButton(0, 3);
		assertFalse(button.isOn());
		LightsOutButton button2 = new LightsOutButton(2,2);
		button2.toggle();
		assertTrue(button2.isOn());
	}	
	
	@Test
	public void testToggle() {
		LightsOutButton button = new LightsOutButton(1, 1);
		button.toggle();
		assertTrue(button.isOn());
		
		LightsOutButton button2 = new LightsOutButton(3,1);
		assertTrue(!button2.isOn());
	}	
	
	
}