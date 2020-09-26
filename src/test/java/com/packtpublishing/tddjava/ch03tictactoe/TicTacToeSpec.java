package com.packtpublishing.tddjava.ch03tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.experimental.categories.Category;
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

	@Test
	public void nacheinemZugWelchseltDerPlayer() {
		assertEquals('X', game.whoseNext());
		game.play(1, 2);
		assertEquals('O', game.whoseNext());
		game.play(2, 1);
		assertEquals('X', game.whoseNext());
	}

	@Test
	public void normalerweiseKeinGewinner() {
		assertEquals("kein Gewinner", game.play(1, 2));
	}

	@Test
	public void nach3ZuegenErsteSpalteXGewinnt() {
		game.play(1, 1);
		game.play(3, 1);
		game.play(1, 2);
		game.play(3, 2);

		assertEquals("X hat gewonnen", game.play(1, 3));
	}
	@Test
	public void nach3ZuegenZweiteOderDritteSpalteXGewinnt() {
		game.play(2, 1);
		game.play(3, 1);
		game.play(2, 2);
		game.play(3, 2);
		assertEquals("X hat gewonnen", game.play(2, 3));

		game = new TicTacToe();
		game.play(3, 1);
		game.play(2, 1);
		game.play(3, 2);
		game.play(2, 2);
		assertEquals("X hat gewonnen", game.play(3, 3));
	}

	@Test
	public void nach3ZuegenErsteReiheXGewinnt() {
		game.play(1, 1);
		game.play(2, 2);
		game.play(2, 1);
		game.play(3, 2);

		assertEquals("X hat gewonnen", game.play(3, 1));
	}
	@Test
	public void nach3ZuegenZweiteReiheXGewinnt() {
		game.play(1, 2);
		game.play(2, 1);
		game.play(2, 2);
		game.play(3, 3);

		assertEquals("X hat gewonnen", game.play(3, 2));
	}
	@Test
	public void nach3ZuegenDritteReiheXGewinntXXX() {
		game.play(1, 3);
		game.play(2, 1);
		game.play(2, 3);
		game.play(3, 2);
		game.play(3, 3);
		//assertEquals("X hat gewonnen", game.play(3, 3));
	}
	@Test
	@Category(DiagonalTest.class)
	public void nach3ZuegenDiagonalXGewinnt() {
		game.play(1, 1);
		game.play(1, 3);
		game.play(2, 2);
		game.play(2, 1);

		assertEquals("X hat gewonnen", game.play(3, 3));
	}
	@Test
	public void nach3ZuegenDiagonal2XGewinnt() {
		game.play(1, 3);
		game.play(1, 2);
		game.play(2, 2);
		game.play(2, 1);

		assertEquals("X hat gewonnen", game.play(3, 1));
	}

	@Test
	public void nach3ZuegenDiagonalOGewinnt() {
		game.play(1, 1);
		game.play(1, 3);
		game.play(2, 1);
		game.play(2, 2);
		game.play(3, 2);

		assertEquals("O hat gewonnen", game.play(3, 1));
	}
}
