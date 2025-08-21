import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements GameInterface {
   
    private List<Player> players ; 
    private Board board ; 
    
    


	public Game(List<Player> players, ClassicBoard board) {
		super();
		this.players = players;
		this.board = board;
	}
	public Game() {
		players = new ArrayList<>();
		
	}
     
	@Override
	public void start() {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("WELCOME TO TIC-TOC-TIC GAME! ");
		System.out.println("Press Any key to Continue : ");
		scan.nextLine();
		System.out.println(" Enter How many players are playing : ");
		int noOfPlayers = scan.nextInt();
		scan.nextLine();
		for(int i = 0 ;i < noOfPlayers ; i ++ ) {
			System.out.println( "Enter the "+ (i+1) +"th Player Name : ");
			String name = scan.nextLine();
			players.add( new Player( i + 1 , name ));
			System.out.println((i+1) +"th Player  is Successfully Added.");
			
		}
		System.out.println("Enter the Size of Board  row and colmn : ");
		
		int rowSize = scan.nextInt();
		int colSize = scan.nextInt();
		
		board = new ClassicBoard(rowSize, colSize);
		System.out.println("************");
		System.out.println(" Players are : ");
		players.stream().forEach( e -> System.out.println( e ));
		System.out.println( "**********");
		System.out.println("Let's Start the Game : ");
		
		boolean isGameOver = false;
		int postion = 0 ; 
	    do {
	    	board.printBoard();
	    	System.out.println( players.get(postion).getPlayerName()+" your Trun ");
	    	boolean movedCompleted = false ;
	    	do {
	    	System.out.println("Enter the Row Number & Col Number ");
	    	int rowNumber = scan.nextInt();
	    	int colNumber = scan.nextInt();
	    	movedCompleted = board.isValidMove(rowNumber, colNumber);
	    	if( movedCompleted ) {
	    		board.setMove( players.get(postion ), rowNumber, colNumber);
	    	}
	    	else {
	    		System.out.println("your Moved is Invalid. Please Try Another Cell ");
	    	}
	    	} while ( !movedCompleted );
	    	
	    	boolean isTie = board.isTie();
	    	if( isTie ) {
	    		System.out.println("Game is Tie!\nPlay Again");
	    		return ;  
	    	}
	    	isGameOver = board.isAnyOneWin();
	    	postion ++ ; 
	    	postion %= noOfPlayers ; 
	    }
	    while ( isGameOver );
		
	    int winnerPlayerId = board.getWinnerPlayerId();
	    
	    System.out.println("*****Game Over!******");
	    System.out.println( "Congratulations "+players.get(winnerPlayerId  - 1).getPlayerName() );
	    System.out.println("***************");
	    
	    System.out.println("Thank You Playing Wonderful Game! ");
		
	}
	
	@Override
	public String toString() {
		return "Game [players=" + players + ", board=" + board + "]";
	}

	

}
