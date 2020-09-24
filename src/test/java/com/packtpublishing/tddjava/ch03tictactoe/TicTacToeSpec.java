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
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.play(4, 2));
		org.junit.Assert.assertEquals("Koordinate = 4 ist außerhalb des Spielfeldes", thrown.getMessage());
	}

	@Test
	public void beimSteinSetzenWennYzuGrossAusserhalbWerfeException() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.play(2, 4));
		org.junit.Assert.assertEquals("Koordinate = 4 ist außerhalb des Spielfeldes", thrown.getMessage());
	}

	@Test
	public void beimSteinSetzenWennXzuKleinAusserhalbWerfeException() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.play(-1, 2));
		org.junit.Assert.assertEquals("Koordinate = -1 ist außerhalb des Spielfeldes", thrown.getMessage());
	}

	@Test
	public void beimSteinSetzenWennYzuKleinAusserhalbWerfeException() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.play(1, -1));
		org.junit.Assert.assertEquals("Koordinate = -1 ist außerhalb des Spielfeldes", thrown.getMessage());
	}

	@Test
	public void beimSteinSetzenWennFeldSchonBelegtWerfeException() {
		game.play(1, 2);
		game.play(3, 3);

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> game.play(1, 2));
		org.junit.Assert.assertEquals("dieses Feld ist schon belegt", thrown.getMessage());
	}

}
