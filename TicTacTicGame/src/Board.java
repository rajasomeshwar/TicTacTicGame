
public interface Board {
	
	final static int EMPTY = -1 ;
	
	public void printBoard();
	
	public boolean isValidMove( int rowNumber , int  colNumber );
    
	public boolean setMove( Player player , int rowNumber , int colNumber );
	
	
	public boolean isAnyOneWin();
	
	public int getWinnerPlayerId();

	public boolean isTie();
	

}
