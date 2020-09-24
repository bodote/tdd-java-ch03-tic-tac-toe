package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

	char[][] spielbrett = {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};
	String ausserhalbError = " ist außerhalb des Spielfeldes";

	public void play(int x, int y) throws RuntimeException {
		checkRange(x);
		checkRange(y);

		setBox(x, y);

		return;
	}

	private void setBox(int x, int y) {
		if (spielbrett[x - 1][y - 1] != '0')
			throw new RuntimeException("dieses Feld ist schon belegt");
		spielbrett[x - 1][y - 1] = 'X';
	}

	private void checkRange(int x) {
		if (x > 3 || x < 1)
			throw new RuntimeException("Koordinate = " + Integer.toString(x) + ausserhalbError);
	}
}
