package connectfour;

/**
 * This class aims to validate game possibilities
 * 
 * @author
 *
 */
public class Validate {
	private static final int WIDTH = 7, HEIGHT = 6;

	/**
	 * Check if the board has 4 disks in a row, column or diagonal
	 * 
	 * @param board
	 * @return the winner player (1 or 2) or return 0 if there is not a winner
	 */
	public int checkWinner(int[][] board) {
		int numberOfEqualSequencePieces, player;

		/*
		 * Checks four equal pieces in a row
		 */
		for (int y = 0; y < HEIGHT; y++) {
			numberOfEqualSequencePieces = 0; 
			player = 0;
			for (int x = 0; x < WIDTH; x++) {
				if (board[x][y] == player)
					numberOfEqualSequencePieces++;
				else {
					numberOfEqualSequencePieces = 1;
					player = board[x][y];
				}
				if (numberOfEqualSequencePieces == 4 && player > 0)
					return player;
			}
		}

		for (int x = 0; x < WIDTH; x++) {
			numberOfEqualSequencePieces = 0;
			player = 0;
			for (int y = 0; y < HEIGHT; y++) {
				if (board[x][y] == player)
					numberOfEqualSequencePieces++;
				else {
					numberOfEqualSequencePieces = 1;
					player = board[x][y];
				}
				if (numberOfEqualSequencePieces == 4 && player > 0)
					return player;
			}
		}

		for (int xStart = 0, yStart = 2; xStart < 4;) {
			numberOfEqualSequencePieces = 0;
			player = 0;
			for (int x = xStart, y = yStart; x < WIDTH && y < HEIGHT; x++, y++) {
				if (board[x][y] == player) {
					numberOfEqualSequencePieces++;
				} else {
					numberOfEqualSequencePieces = 1;
					player = board[x][y];
				}
				if (numberOfEqualSequencePieces == 4 && player > 0) {
					return player;
				}
			}

			if (yStart == 0) {
				xStart++;
			} else {
				yStart--;
			}
		}

		for (int xStart = 0, yStart = 3; xStart < 4;) {
			numberOfEqualSequencePieces = 0;
			player = 0;
			for (int x = xStart, y = yStart; x < WIDTH && y >= 0; x++, y--) {
				if (board[x][y] == player) {
					numberOfEqualSequencePieces++;
				} else {
					numberOfEqualSequencePieces = 1;
					player = board[x][y];
				}
				if (numberOfEqualSequencePieces == 4 && player > 0) {
					return player;
				}
			}
			if (yStart == HEIGHT - 1) {
				xStart++;
			} else {
				yStart++;
			}
		}
		return 0;
	}
}
