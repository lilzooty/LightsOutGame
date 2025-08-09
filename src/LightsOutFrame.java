import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * This class represents the frame of the 5x5 lights out game
 * 
 * @author nicholas kroop
 * @version 4-9-2023
 */
public class LightsOutFrame extends JFrame implements ActionListener{
	private LightsOutButton[][] lightsOutGrid;
	private JButton randomSetupButton;
	private JButton manualSetupButton;
//	private JLabel winMessage; 
//	private JButton resetButton;
	private boolean inManualSetup;
	
	
	public LightsOutFrame() {
		inManualSetup = false;
		lightsOutGrid = new LightsOutButton[5][5];
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel firstPanel = new JPanel(new GridLayout(5,5));
		
		for (int r = 0; r < 5; r++) {
			for(int c = 0; c < 5; c++) {
				lightsOutGrid[r][c] = new LightsOutButton(r, c);
				
			}
		}
		
		randomize();
		
		for (int r = 0; r < 5; r++) {
			for(int c = 0; c < 5; c++) {
				firstPanel.add(lightsOutGrid[r][c]);
				lightsOutGrid[r][c].addActionListener(this);
			}
		}
		
		JPanel secondPanel = new JPanel(new GridLayout(1,2));
		randomSetupButton = new JButton("Randomize Lights");
		manualSetupButton = new JButton("Enter Manual Setup");
		secondPanel.add(randomSetupButton);
		secondPanel.add(manualSetupButton);
		
		JPanel thirdPanel = new JPanel(new GridLayout(1,2));
		thirdPanel.add(firstPanel);
		thirdPanel.add(secondPanel);
		
		this.setContentPane(thirdPanel);
		randomSetupButton.addActionListener(this);
		manualSetupButton.addActionListener(this);
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();
		
		
	}

	/**
	 * randomizes the grid of lightbuttons 
	 * so that some are turned on at the start of the game
	 */
	void randomize() {
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			int randIntRow = rand.nextInt(4);
			int randIntColumn = rand.nextInt(4);
			toggleLight(randIntRow, randIntColumn);
		}
	}
	
	
	boolean lightIsOn(int row, int column) {
		if ((row < 0 || row > 4) || (column < 0 || column > 4)) {
			throw new IndexOutOfBoundsException("row/column index is out of bounds!");
		}
		return lightsOutGrid[row][column].isOn();
	}
	
	/**
	 * toggles the light that is clicked and all
	 * lights to its north, east, south, and west
	 * unless its a special case
	 * @param row
	 * @param column
	 */
	void toggleLight(int row, int column) {
		if ((row < 0 || row > 4) || (column < 0 || column > 4)) {
			throw new IndexOutOfBoundsException("row/column index is out of bounds!");
		}
		
		lightsOutGrid[row][column].toggle();
		
		if (row == 0) {
			lightsOutGrid[row+1][column].toggle();
		}
		else if (row == 4) {
			lightsOutGrid[row-1][column].toggle();
			
		}
		else {
			lightsOutGrid[row+1][column].toggle();
			lightsOutGrid[row-1][column].toggle();
		}
		
		if (column == 0) {
			lightsOutGrid[row][column+1].toggle();
		} 
		else if (column == 4){
			lightsOutGrid[row][column-1].toggle();
		}
		else {
			lightsOutGrid[row][column+1].toggle();
			lightsOutGrid[row][column-1].toggle();
		}
		System.out.println("Light is toggled");
	}

	/**
	 * enables manual setup mode where the only light
	 * toggled is the one clicked 
	 */
	void toggleManualMode() {
		inManualSetup = !inManualSetup;
		if (inManualSetup) {
			manualSetupButton.setText("Exit Manual Setup");
		}
		else {
			manualSetupButton.setText("Enter Manual Setup");
		}
	}

	
	/**
	 * all of the actions that may be performed 
	 * when clicking on any of the respective buttons 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(randomSetupButton)) {
			randomize();
		}
		else if (e.getSource().equals(manualSetupButton)) {
			toggleManualMode();
		}
		else if (e.getSource() instanceof LightsOutButton) {
			LightsOutButton button = (LightsOutButton) e.getSource();
			int row = button.getRow();
			int col = button.getColumn();
			if (inManualSetup) {
				lightsOutGrid[row][col].toggle();
			}
			else {
				toggleLight(row, col);
			}
			
		}
		
	}
	
}
