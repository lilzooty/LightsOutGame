

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel; 

/**
 * this class represents the object of a
 * lightbulb button for the game lights out 
 * 
 * @author nicholas kroop
 * @Version 4-9-2023
 */
public class LightsOutButton extends JButton {
	private int row;
	private int column;
	private boolean isOn;
	
	private JLabel offLabel;
	private JLabel onLabel;
	
	public LightsOutButton(int rowNumber, int colNumber) { 
		super();
		row = rowNumber;
		column = colNumber;
		isOn = false;
		ImageIcon offImage = new ImageIcon("resources/off.png");
		offLabel = new JLabel(offImage);
		add(offLabel, BorderLayout.CENTER);
		offLabel.setVisible(true);
	
		// TO DO change the iconOn image to just 'on.png' before turning in!
		ImageIcon onImage = new ImageIcon("resources/on.png");
		onLabel = new JLabel(onImage);
		add(onLabel, BorderLayout.CENTER);
		onLabel.setVisible(false);
	}
	
	/**
	 * this method toggles a single lightbulb on or off
	 */
	void toggle() {
		if (isOn == false) { 
			offLabel.setVisible(false);
			onLabel.setVisible(true);
			isOn = true;
			System.out.println("Light is on");
		}
		else { 
			onLabel.setVisible(false);
			offLabel.setVisible(true);
			isOn = false;
			System.out.println("Light is off");
		}
	}
	
	/**
	 * getter method for the row number of a lightbutton
	 * @return int row
	 */
	int getRow() {
		return row;
	}
	
	/**
	 * getter method for the column number of a lightbutton
	 * @return int column
	 */
	int getColumn() { 
		return column;
	}
	
	/**
	 * gets the true or false value if a light is on
	 * @return
	 */
	boolean isOn() {
		return isOn;
	}
}
