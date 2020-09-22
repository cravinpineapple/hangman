package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.HangMan.GameState;
import view.HangManPanel;

public class HangManListener implements ActionListener {

	HangManPanel panel;

	public HangManListener(HangManPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) (e.getSource());

		if (button == panel.getAlphabetButtons()[26]) {
			panel.enableButtons();
			panel.getHangMan().newGame();
			panel.setGuessFieldText(panel.getHangMan().getCurrentGuess());
			panel.setGameKeyFieldText(panel.getHangMan().getCurrentGameKey());
		}
		else {
			panel.getHangMan().guessLetter(button.getText().charAt(0));
			panel.setGuessFieldText(panel.getHangMan().getCurrentGuess());
			//int disableIndex = (int) (button.getText().charAt(0) - 'A');
			button.setEnabled(false);
			panel.getHangMan().checkWin();

			if (panel.getHangMan().getWin() || panel.getHangMan().getHealth() < 1) {
				panel.disableButtons();
				panel.getHangMan().setGameState(GameState.GAMEOVER);
			}
		}

		panel.getCanvas().repaint();
	}
	
}
