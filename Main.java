import javax.swing.JFrame;

import view.HangManPanel;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setLocation(300, 0);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		HangManPanel hangManPanel = new HangManPanel(window);
		hangManPanel.init();
		window.pack();
		window.setVisible(true);

	}
}
