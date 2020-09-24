package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by vfarcic on 19/03/15.
 */
public class TicTacToe {

	String ausserhalbError = " ist außerhalb des Spielfeldes";

	public void place(int x, int y) throws RuntimeException {
		if (x > 2 || x < 0)
			throw new RuntimeException("X = " + Integer.toString(x) + ausserhalbError);
		if (y > 2 || y < 0)
			throw new RuntimeException("Y = " + Integer.toString(y) + ausserhalbError);

		return;
	}
}
