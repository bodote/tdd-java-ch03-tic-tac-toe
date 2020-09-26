package com.packtpublishing.tddjava.ch03tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {

	// private char[][] spielbrett = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0',
	// '\0', '\0'}};
	private ArrayList<List<Character>> spielbrett = new ArrayList<>(3);
	String keinGewinner = "kein Gewinner";
	private String ausserhalbError = " ist außerhalb des Spielfeldes";
	private char nextPlayer = 'X';

	public TicTacToe() {

		for (int i = 0; i < 3; i++) {
			spielbrett.add(Arrays.asList(Character.valueOf('\0'), Character.valueOf('\0'), Character.valueOf('\0')));
		}
	}

	public String play(int x, int y) throws RuntimeException {
		checkRange(x);
		checkRange(y);

		setBox(x, y);

		if (checkGewinner('X') == ('X'))
			return "X hat gewonnen";
		if (checkGewinner('O') == ('O'))
			return "O hat gewonnen";
		return keinGewinner;

	}

	private char checkGewinner(char player) {
		long volleReihe = spielbrett.stream().filter(row -> checkRow(player, row) == player).count();
		if (volleReihe > 0)
			return player;

		if ((spielbrett.stream().filter(row -> row.get(0).equals(player)).count() == 3)
				|| (spielbrett.stream().filter(row -> row.get(1).equals(player)).count() == 3)
				|| (spielbrett.stream().filter(row -> row.get(2).equals(player)).count() == 3))
			return player;
		// diagonal
		if ((spielbrett.get(0).get(0).equals(player) && spielbrett.get(1).get(1).equals(player)
				&& spielbrett.get(2).get(2).equals(player)))
			return player;
		boolean b1 = spielbrett.get(2).get(0).equals(player);
		boolean b2 = spielbrett.get(1).get(1).equals(player);
		boolean b3 = spielbrett.get(0).get(2).equals(player);
		if (b3 ) {
			if (b2 ) 
				if (b1)
					return player;
		}

		return '.';

	}

	private char checkRow(char player, List row) {
		long elementsOfPlayer = row.stream().filter(element -> element.equals(player)).count();
		if (elementsOfPlayer == 3)
			return player;
		return '.';
	}

	private void setBox(int x, int y) {
		if (spielbrett.get(x - 1).get(y - 1) != '\0')
			throw new RuntimeException("dieses Feld ist schon belegt");
		spielbrett.get(x - 1).set(y - 1, nextPlayer);
		if (nextPlayer == 'X')
			nextPlayer = 'O';
		else
			nextPlayer = 'X';

	}

	private void checkRange(int x) {
		if (x > 3 || x < 1)
			throw new RuntimeException("Koordinate = " + Integer.toString(x) + ausserhalbError);
	}

	public char whoseNext() {
		return nextPlayer;
	}
}
