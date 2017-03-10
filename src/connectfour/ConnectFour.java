package connectfour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ConnectFour {
	private static final int WIDTH = 7, HEIGHT = 6;
	private static int playerTurn;
	Random random = new Random();
	private ArrayList<Integer> availableMovesList = new ArrayList<>();

	private int[] columnHeight = new int[WIDTH];
	private int[][] board = new int[WIDTH][HEIGHT];

	Output output = new Output();
	Validate validate = new Validate();

	public void gameSetup() {
		playerTurn = 1;
	}

	private void switchPlayerTurn() {
		if (playerTurn == 1) {
			setPlayerTurn(2);
		} else {
			setPlayerTurn(1);
		}

	}

	public void play() {
		gameSetup();
		int column;

		while (true) {
			availableMovesList.clear();
			column = 0;

			availableMovesList = findAvailableMoves();

			if (availableMovesList.size() == 0) {
				output.drawMessage();
				break;
			} else if (availableMovesList.size() > 0) {
				Collections.shuffle(availableMovesList);
				column = ((Integer) availableMovesList.get(0)).intValue();
			}
			board[column][columnHeight[column]] = playerTurn;
			columnHeight[column]++;

			int winner = 0;
			winner = validate.checkWinner(board);
			output.printGrid(board);

			if (winner > 0) {
				output.printGrid(board);
				output.printWinner(winner);
				break;
			}
			switchPlayerTurn();
		}
	}

	private ArrayList<Integer> findAvailableMoves() {
		ArrayList<Integer> availableMoves = new ArrayList<>();
		for (int x = 0; x < WIDTH; x++) {
			if (columnHeight[x] >= HEIGHT)
				continue;
			availableMoves.add(new Integer(x));
		}
		return availableMoves;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public static void setPlayerTurn(int playerTurn) {
		ConnectFour.playerTurn = playerTurn;
	}

}