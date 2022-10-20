// Assignment 3 - Question 4 WordSearch
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		
		
		int rows= board.length;
		int cols= board[0].length;
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				int current = 0;
				boolean isIn = wordSearch(i, j, rows, cols, board, word, current);
				if(isIn)return true;
			}
		}
		return false;
	}
	
	public static boolean wordSearch(int i, int j, int rows, int cols, char[][] board, String word, int current){
		boolean isPresent = false;
		
		if(current == word.length())return true;
		
		else if(i == rows || j == cols || i<0 || j<0 || board[i][j]!=word.charAt(current))return false;
		
		else{
			if(board[i][j] == word.charAt(current)){
				board[i][j] += 100;
				
				isPresent = (
						wordSearch(i+1, j, rows, cols, board, word, current+1) ||
								wordSearch(i, j+1, rows, cols, board, word, current+1) ||
								wordSearch(i-1, j, rows, cols, board, word, current+1) ||
								wordSearch(i, j-1, rows, cols, board, word, current+1)
				);
				board[i][j] -= 100;
			}
		}
		return isPresent;
	}
	
}
