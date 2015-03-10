
public class Board {
	public int[][] board;
	// Конструктор инициализираш дъската и определящ размера на игралното поле 
	public Board(int x, int y) {
		board = new int[x][y];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] = -1;
			}
		}
	}
	// Paint matrix 
	public void writeMatrix() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				System.out.printf("%d ", board[row][col]);
			}
			System.out.println();
		}
	}
	//Рисува дъската за игра
	public void writeGameBoard() {
		for (int col = 0; col < board[0].length; col++) {
			System.out.print("\t" + col);
		}
		System.out.print("\n");
		for (int row = 0; row < board.length; row++) {
			System.out.print((char) (row + 65) + " ");
			for (int col = 0; col < board[0].length; col++) {
				if ((board[row][col] == -1) || (board[row][col] == -3)) {
					System.out.print("\t" + ".");
				} else if (board[row][col] == 0) {
					System.out.print("\t" + "-");
				} else if (board[row][col] == -2) {
					System.out.print("\t" + "X");
				}

			}
			System.out.println();

		}

	}
	//автоматично поставяне на кораби по терена 
	public void fillBoard(Ship a) {
		int ShipSize = 0;
		int x = 0;
		int y = 0;
		ShipSize = a.getSize();
		Game.shipCount+=ShipSize;
		System.out.println(ShipSize);
		boolean direction = (Math.random() < 0.5) ? true : false;

		if (direction) {
			System.out.println("vertikal");
			y = Math.abs((int) (Math.random() * (board[0].length - 1)));
			x = Math.abs((int) (Math.random() * (board.length - 1 - ShipSize)));
			while (checkOrevlap(ShipSize, y, x, direction)) {
				y = Math.abs((int) (Math.random() * (board[0].length - 1)));
				x = Math.abs((int) (Math.random() * (board.length - 1 - ShipSize)));
			}

			for (int i = 0; i < ShipSize; i++) {
				board[x][y] = -2;
				x++;
			}
		} else {
			System.out.println("horizont");
			y = Math.abs((int) (Math.random() * (board[0].length - 1 - ShipSize)));
			x = Math.abs((int) (Math.random() * (board.length - 1)));
			while (checkOrevlap(ShipSize, y, x, direction)) {
				y = Math.abs((int) (Math.random() * (board[0].length - 1 - ShipSize)));
				x = Math.abs((int) (Math.random() * (board.length - 1)));
			}
			for (int i = 0; i < ShipSize; i++) {
				board[x][y] = -2;
				y++;
			}
		}

		

	}
	//проверка за застъпване на кораби
	public boolean checkOrevlap(int ship, int a, int b, boolean direction) {
		int x = b;
		int y = a;
		boolean flag = false;
		if (direction) {

			for (int i = 0; i < ship; i++) {
				if (board[x][y] == -2) {
					flag = true;

				};
				x++;
			}
		} else {

			for (int i = 0; i < ship; i++) {
				if (board[x][y] == -2) {
					flag = true;

				};
				y++;

			}

		}
		return flag;
	}
	//проверка на предположение 
	public boolean checkGuess (String gusess){
		return true;
	}
	
}
