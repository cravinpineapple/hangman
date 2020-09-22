package model;

import java.util.ArrayList;
import java.util.Random;

public class HangMan {

	public enum GameState {
		READY, PLAYING, GAMEOVER
	}
	
	ArrayList<String> gameKeys = new ArrayList<String>();
	String currentGameKey = "";
	String currentGuess = "";
	GameState gameState = GameState.READY;
	int health = 5;
	boolean win = false;


	public HangMan() {
		initGameKeys();
	}

	public void newGame() {
		health = 5;
		currentGameKey = generateKey();
		initCurrentGuess();
		gameState = GameState.PLAYING;
	}

	public void guessLetter(char letter) {
		boolean found = false;
		String newCurrentGuess = "";

		//updates currentGuess with letter if letter is present in currentGamKey
		//	also marks when letter found so health can be/not be deducted
		for (int i = 0; i < currentGameKey.length(); i++) {
			if (currentGameKey.charAt(i) == letter) {
				found = true;
				newCurrentGuess += letter;
			}
			else {
				newCurrentGuess += currentGuess.charAt(i);
			}
		}

		currentGuess = newCurrentGuess;

		if (!found)
			health--;
	}

	private void initCurrentGuess() {
		currentGuess = "";

		for (int i = 0; i < currentGameKey.length(); i++) {
			currentGuess += ".";
		}
	}

	private String generateKey() {
		Random rand = new Random();

		for (int i = 0; i < currentGameKey.length(); i++)
			currentGuess += ".";

			return gameKeys.get(rand.nextInt(gameKeys.size()));
	}

	public void checkWin() {
		boolean flag = true;

		for (int i = 0; i < currentGameKey.length(); i++) {
			if (currentGameKey.charAt(i) != currentGuess.charAt(i)) {
				flag = false;
				break;
			}
		}

		if (flag) {
			win = true;
			gameState = GameState.GAMEOVER;
		}
	}

	public String getCurrentGameKey() {
		return currentGameKey;
	}

	public String getCurrentGuess() {
		return currentGuess;
	}

	public int getHealth() {
		return health;
	}

	public boolean getWin() {
		return win;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return gameState;
	}

	void initGameKeys() {
		gameKeys.add("communication");
		gameKeys.add("science");
		gameKeys.add("programming");
		gameKeys.add("language");
		gameKeys.add("difficulty");
		gameKeys.add("artificial");
		gameKeys.add("intelligence");
		gameKeys.add("attempts");
		gameKeys.add("screenshot");
		gameKeys.add("baseball");
		gameKeys.add("windows");
		gameKeys.add("learning");
		gameKeys.add("electronics");
		gameKeys.add("beautiful");
		gameKeys.add("internet");
		gameKeys.add("database");
		gameKeys.add("organization");
		gameKeys.add("application");
		gameKeys.add("network");
		gameKeys.add("friendly");
		gameKeys.add("validation");
		gameKeys.add("attempts");
		gameKeys.add("statistics");
		gameKeys.add("physics");
		gameKeys.add("chemistry");
		gameKeys.add("engineering");
		gameKeys.add("school");
		gameKeys.add("industry");
		gameKeys.add("revolution");
		gameKeys.add("progress");
		gameKeys.add("characters");
		gameKeys.add("heavily");
		gameKeys.add("graphics");
	}

}
