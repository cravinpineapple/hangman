package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import model.HangMan.GameState;

public class HangManCanvas extends JPanel {

	HangManPanel panel;

	public HangManCanvas(HangManPanel panel) {
		this.panel = panel;
		setPreferredSize(new Dimension(500, 500));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		GameState state = panel.getHangMan().getGameState();

		g2.setColor(Color.blue);
		if (state == GameState.READY) {
			g2.setFont(new Font("Courier New", Font.BOLD, 30));
			g2.drawString("Press <New> to play!", 5, 50);
		}
		else if (state == GameState.PLAYING) {
			g2.setFont(new Font("Courier New", Font.BOLD, 50));
			g2.drawString("Health Level", 5, 50);

			for (int i = 0; i < panel.getHangMan().getHealth(); i++) {
				g2.fillRect(5 + (i * 55), 60, 50, 50);
			}
		}
		else if (state == GameState.GAMEOVER) {
			String resultText = "You ";
			if (panel.getHangMan().getWin())
				resultText += "Win !!!";
			else
				resultText += "Lost !!!";

			g2.setColor(Color.red);
			g2.setFont(new Font("Courier New", Font.BOLD, 30));
			g2.drawString(resultText, 5, 40);
			g2.setColor(Color.blue);
			g2.drawString("Press <New> to play again!", 5, 80);
		}
		
	}

	

}
