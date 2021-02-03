import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Board board = new Board();
		
		Random computerMoveRow = new Random();
		Random computerMoveColumn = new Random();
		
		boolean term;
		boolean lastInput;
		
		String player_move;
		
		int col=-1, ro=-1;
		char letter1, letter2;
		
		System.out.println("Please enter the column (A, B or C) and then the row (1, 2, or 3) of your move.");
		board.initialize();  
		board.printBoard();
		
		while (!board.isNotFull() && !board.gameWon()) {
			do{
				System.out.print("Player Move (X): ");
				player_move = in.nextLine(); 
				
				term=false;
				lastInput=true;
				
				letter2 = player_move.charAt(0);
				letter1 = player_move.charAt(1);
				
				if (letter2=='A')
					col = 0;
				else if (letter2=='B')
					col = 1;
				else if (letter2=='C')
					col = 2;
				
				if (letter1=='1')
					ro = 0;
				else if (letter1=='2')
					ro = 1;
				else if (letter1=='3')
					ro = 2;
				
				
				if (board.invalidInput(player_move)) { 
					System.out.println("Invalid Input: Please re-enter the column and row of your move (Example: A1).");
					term=true;
					lastInput=false;
				}
				
				
				if (ro!=-1 && col!=-1 && lastInput) {
					if (board.takenPos(ro, col)) {
						System.out.println("The space is already taken. Try again.");
						term=true;
					}	
				}
			} while(term); 
			
			board.playerMove(ro, col);
			board.printBoard();
			
			
			if (board.gameWon()) {
				System.out.println("YOU WIN!");
				break;
			}
			else if (board.isNotFull()) 
				break;
			
			System.out.print("Computer Move (O): ");
			do{
				ro = computerMoveRow.nextInt(3);
				col = computerMoveColumn.nextInt(3);				
			}while(board.takenPos(ro, col));
			
			if (col==0)
				System.out.println("A" + (ro+1));
			if (col==1)
				System.out.println("B" + (ro+1));
			if (col==2)
				System.out.println("C" + (ro+1));
			
			board.computerMove(ro, col);
			board.printBoard();
			
			
			if (board.gameWon()) {
				System.out.println("COMPUTER WON!");
				break;
			}
			else if (board.isNotFull())   
				break;

		}
		
		if (board.isNotFull() && !board.gameWon()) 
			System.out.println("GAME TIED");
	}

}
