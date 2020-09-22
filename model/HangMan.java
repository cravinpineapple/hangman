package model;

import java.util.ArrayList;
import java.util.Random;

public class HangMan {

	public enum GameState {
		READY, PLAYING, GAMEOVER
	}
	
	ArrayList<String> gameKeys = new ArrayList<String>();
	String currentGameKey = "";
	GameState gameState = GameState.READY;
	int health = 5;


	public HangMan() {
		initGameKeys();
	}

	public void newGame() {
		health = 5;
		generateKey();
	}

	String generateKey() {
		Random rand = new Random();
		return gameKeys.get(rand.nextInt(gameKeys.size()));
	}

	public String getCurrentGameKey() {
		return currentGameKey;
	}

	public int getHealth() {
		return health;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
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
