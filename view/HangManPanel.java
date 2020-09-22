package view;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.HangManListener;
import model.HangMan;

public class HangManPanel {

	private JFrame window;

	private HangMan hangMan = new HangMan();

	private JTextField gameKeyField = new JTextField("");
	private JTextField guessField = new JTextField("");
	
	HangManCanvas canvas;

	private JButton[] alphabet = new JButton[27];



	public HangManPanel(JFrame window) {
		this.window = window;
	}

	public void init() {
		// container for JPanel's
		Container cp = window.getContentPane();

		gameKeyField.setEditable(false);
		gameKeyField.setFont(new Font("Courier New", Font.BOLD, 20));
		gameKeyField.setForeground(Color.red);
		guessField.setEditable(false);
		guessField.setFont(new Font("Courier New", Font.BOLD, 20));
		
		

		// north panel 2x1 layout for gamekey & guess
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));
		northPanel.add(gameKeyField);
		northPanel.add(guessField);
		cp.add(BorderLayout.NORTH, northPanel);

		// center panel for canvas (health/game over message)
		JPanel centerPanel = new JPanel();
		canvas = new HangManCanvas(this);
		centerPanel.add(canvas);
		cp.add(BorderLayout.CENTER, centerPanel);

		// south panel for alphabet buttons and new game
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(4, 7));
		initAlphabet();
		addAlphabetToPanel(southPanel);
		cp.add(BorderLayout.SOUTH, southPanel);

		HangManListener hangManListener = new HangManListener(this);
		for (var b : alphabet) {
			b.addActionListener(hangManListener);
		}
	}

	void initAlphabet() {
		for (int i = 0; i < 27; i++) {
			if (i == 26) {
				alphabet[i] = new JButton("New");
				break;
			}

			char letter = (char) (97 + i);
			alphabet[i] = new JButton(Character.toString(letter));
			
			alphabet[i].setEnabled(false);
		}
	}

	void addAlphabetToPanel(JPanel panel) {
		for (var b : alphabet) {
			panel.add(b);
		}
	}

	public void enableButtons() {
		for (var b : alphabet) {
			b.setEnabled(true);
		}
	}

	public void disableButtons() {
		for (int i = 0; i < 26; i++)
			alphabet[i].setEnabled(false);
	}

	public JButton[] getAlphabetButtons() {
		return alphabet;
	}

	public HangMan getHangMan() {
		return hangMan;
	}

	public HangManCanvas getCanvas() {
		return canvas;
	}

	public void setGuessFieldText(String guess) {
		guessField.setText(guess);
	}

	public void setGameKeyFieldText(String gameKey) {
		gameKeyField.setText(gameKey);
	}


}