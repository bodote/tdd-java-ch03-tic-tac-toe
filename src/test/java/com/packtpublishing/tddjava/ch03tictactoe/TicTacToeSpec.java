package com.packtpublishing.tddjava.ch03tictactoe;

import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeSpec {

	TicTacToe game;

	@Before
	public void setUp() {
		game = new TicTacToe();
	}

	@Test
	public void beimSteinSetzenWennXzuGrossAusserhalbWerfeException() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.place(4, 2));
		org.junit.Assert.assertEquals("X = 4 ist außerhalb des Spielfeldes", thrown.getMessage());
	}

	@Test
	public void beimSteinSetzenWennYzuGrossAusserhalbWerfeException() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.place(2, 4));
		org.junit.Assert.assertEquals("Y = 4 ist außerhalb des Spielfeldes", thrown.getMessage());
	}

	@Test
	public void beimSteinSetzenWennXzuKleinAusserhalbWerfeException() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.place(-1, 2));
		org.junit.Assert.assertEquals("X = -1 ist außerhalb des Spielfeldes", thrown.getMessage());
	}

	@Test
	public void beimSteinSetzenWennYzuKleinAusserhalbWerfeException() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.place(1, -1));
		org.junit.Assert.assertEquals("Y = -1 ist außerhalb des Spielfeldes", thrown.getMessage());
	}
}
