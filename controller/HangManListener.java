package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.HangMan.GameState;
import view.HangManPanel;

public class HangManListener implements ActionListener {

	HangManPanel panel;

	public HangManListener(HangManPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();

		if (button == panel.getAlphabetButtons()[26]) {
			panel.enableButtons();
			panel.getHangMan().newGame();
			panel.getHangMan().setGameState(GameState.PLAYING);
			panel.setGuessField("..........");
			panel.setGameKeyField(panel.getHangMan().getCurrentGameKey());
			
		}
	}
	
}
