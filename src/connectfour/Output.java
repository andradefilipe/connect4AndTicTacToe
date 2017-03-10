package connectfour;

/**
 * This class has all possible console outputs
 * 
 * @author
 *
 */
public class Output {

	private static final int WIDTH = 7, HEIGHT = 6;

	/**
	 * Prints the current grid situation
	 * 
	 * @param grid
	 */
	public void printGrid(int[][] grid) {
		System.out.println("");
		for (int j = HEIGHT - 1; j >= 0; j--) {
			for (int i = 0; i < WIDTH; i++) {

				if (grid[i][j] == 2) {
					System.out.print(" X");
				} else if (grid[i][j] == 1) {
					System.out.print(" O");
				} else
					System.out.print(" .");
			}
			System.out.println("");
		}
		System.out.println(" 1 2 3 4 5 6 7");
	}

	/**
	 * Printed when the game ends with a tie
	 */
	public void drawMessage() {
		System.out.println("");
		System.out.println("It's a tie.");
	}

	/**
	 * Prints the game winner
	 */
	public void printWinner(int winner) {
		if (winner == 1)
			System.out.println("Player 1 won");
		else
			System.out.println("Player 2 won");
	}

}
