import java.util.Random;

public class Board {
	
	private char[][] board = new char[3][3];
	
	public void initialize() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++)
				board[i][j]=' ';
		}
	}
	
	public void printBoard() {
		System.out.println("  A B C");
		for (int i=0; i<3; i++) {
			System.out.print(i+1);
			for (int j=0; j<3; j++)
				System.out.print("|" + board[i][j]);
			System.out.println("|");
		}
		System.out.println("");
	}
	
	public boolean isNotFull() {
        boolean flag = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    flag = false;
                }
            }
        }

        return flag;
    }
	
	public boolean gameWon() {
		
			boolean row = false;
			boolean column = false;
			boolean diag = false;
			
			for (int i = 0; i < 3; i++) {
	            if (((board[i][0] != ' ') && (board[i][0] == board[i][1]) && (board[i][1] == board[i][2]))) {
	                row = true;
	            }
	        }
			
			for (int i = 0; i < 3; i++) {
	            if (((board[0][i] != ' ') && (board[0][i] == board[1][i]) && (board[1][i] == board[2][i]))) {
	                column = true;
	            }
	        }
			
			if ((board[0][0] != ' ') && (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
				diag = true;
			if ((board[0][2] != ' ') && (board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
				diag = true;
			
			return (row || column || diag);
    }
	
	public boolean invalidInput(String move) {
		boolean flag = true;
		if (move.equals("A1") || move.equals("A2") || move.equals("A3") || move.equals("B1") || move.equals("B2") || move.equals("B3") || move.equals("C1") || move.equals("C2") || move.equals("C3"))
			flag = false;
		return flag;
	}
	
	public void playerMove(int row, int column) {
			board[row][column]='X';		
	}
	
	public boolean takenPos(int row, int column) {
		boolean flag = true;
		
		if (board[row][column]==' ')
				flag = false;		
		return flag;
	}
	
	public void computerMove(int row, int col) {
		board[row][col]='O';
	}
}
