import java.util.Arrays;

public class ClassicBoard implements Board {
    private int rowSize , colSize ;
    private int totalFilledPeaces ; 
    private int[][] gird ;
    
    

	public ClassicBoard(int rowSize, int colSize) {
		super();
		this.rowSize = rowSize;
		this.colSize = colSize;
		 gird = new int[rowSize][ colSize ];
		for(int[] rows : gird )
			Arrays.fill(  rows, EMPTY);
	
	}


	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void setColSize(int colSize) {
		this.colSize = colSize;
	}

	public int[][] getGird() {
		return gird;
	}

	public void setGird(int[][] gird) {
		this.gird = gird;
	}



    public boolean isEmptyCell( int value ) {
    	return EMPTY == value ; 
    }

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		System.out.println("Number's represents the Player's Id.");
		System.out.println("E represents the Ceil is EMPTY");
		System.out.println("********* Board ******* ");
		
		for(int[] row : gird ) {
			System.out.print("\t");
			for(int v : row ) {
			
					System.out.print((isEmptyCell( v ) ?"E ":v+" "));
			
			}
			System.out.println();
		}
		System.out.println("********************");
		
		
	}




	@Override
	public boolean isValidMove(int rowNumber, int colNumber) {
		// TODO Auto-generated method stub
		if( rowNumber > -1 && rowNumber < rowSize && colNumber >-1 && colNumber < colSize ) {
			return gird[ rowNumber ][ colNumber ] == EMPTY ; 		
		}
		return false;
	}




	@Override
	public boolean setMove(Player player, int rowNumber, int colNumber) {
		 if( isValidMove ( rowNumber , colNumber )) {
			 gird[ rowNumber ][ colNumber ] = player.getPlayerId();
			 totalFilledPeaces ++ ; 
			 return true; 
		 }
		return false;
	}



   public int getWinnerPlayerId () {
	   
	   return checkAnyOneOfThemWin();
   }
   public boolean isAnyOneWin() {
//	   System.out.println(" debug "+ checkAnyOneOfThemWin());
	   return checkAnyOneOfThemWin() == EMPTY ; 
   }
	
	public int checkAnyOneOfThemWin() {
		// TODO Auto-generated method stub
		// checking row by row 
		for(int i = 0 ;i < rowSize ; i ++ ) {
			
			boolean rowWin = true;
			for(int j = 0 ; j< colSize ; j ++ ) {
				if( gird[ i ][ j] != gird[ i ][ 0 ]) {
					rowWin = false;
					break;
				}
			}
			if( rowWin  && gird[ i ][ 0 ] != EMPTY) return gird[ i ][ 0 ] ;
			
		}
		// col by col 
		for(int col = 0 ; col < colSize ; col ++ ) {
			boolean colWin = true;
			for(int row = 0 ; row < rowSize ; row ++ ) {
				if( gird[ row ][ col ] != gird[ 0 ][ col ]) {
					colWin = false; 
					 break;
				}
				
				
			}
			if( colWin && gird[ 0 ][ col ] != EMPTY ) return gird[ 0 ][ col ];
		}
		// diagonal check
		int i = 0 , j =  0 ; 
		for( i = 0, j = 0  ;i <  Math.min(rowSize , colSize ) ;i ++, j ++  ) {
			if( gird[ i ][ j ] != gird[ 0 ][ 0 ]  ) break;
		}
		if( i == Math.min(rowSize , colSize ) && gird[ 0 ][ 0 ] != EMPTY) return gird[ 0 ][ 0 ] ;
		
		i = 0 ;
		j = colSize - 1 ;
		// diagonal check from right to left 
		while ( j > -1 && i < rowSize ) {
			if(  gird[ i ][ j ] != gird[ 0 ][ colSize - 1 ]) break ;
			j -- ; 
			i ++ ; 
		}
		if( j == -1 && gird[ 0 ][ colSize - 1] != EMPTY) return gird[ 0 ][ colSize - 1 ];
		
		return EMPTY ; 
	} 
    
    
    
	@Override
	public String toString() {
		return "ClassicBoard [rowSize=" + rowSize + ", colSize=" + colSize + ", gird=" + Arrays.toString(gird) + "]";
	}


	@Override
	public boolean isTie() {
		// TODO Auto-generated method stub
		return totalFilledPeaces == rowSize * colSize ;
	}
	
}
