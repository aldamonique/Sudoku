package sudoku;

import java.util.Random;

public class Puzzle {
	// All variables have package access
	   // The numbers on the puzzle
	   int[][] numbers = new int[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   // The clues - isGiven (no need to guess) or need to guess
	   boolean[][] isGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   Random random = new Random();

	   // Constructor
	   public Puzzle() {
	      super();
	   }

	   // Generate a new puzzle given the number of cells to be guessed, which can be used
	   //  to control the difficulty level.
	   // This method shall set (or update) the arrays numbers and isGiven
	   //t: // Gera um novo quebra-cabeça dado o número de células a serem adivinhadas, que pode ser usado
	// para controlar o nível de dificuldade.
	// Este método deve definir (ou atualizar) os números dos arrays e isGiven
	   public void newPuzzle(Level level) {
	      // I hardcode a puzzle here for illustration and testing.
	      if(level == Level.dificil) {
	    	  int[][] hardcodedNumbers = 
	      
	         {{5, 3, 4, 6, 7, 8, 9, 1, 2},
	          {6, 7, 2, 1, 9, 5, 3, 4, 8},
	          {1, 9, 8, 3, 4, 2, 5, 6, 7},
	          {8, 5, 9, 7, 6, 1, 4, 2, 3},
	          {4, 2, 6, 8, 5, 3, 7, 9, 1},
	          {7, 1, 3, 9, 2, 4, 8, 5, 6},
	          {9, 6, 1, 5, 3, 7, 2, 8, 4},
	          {2, 8, 7, 4, 1, 9, 6, 3, 5},
	          {3, 4, 5, 2, 8, 6, 1, 7, 9}};
	    	  
	    	  for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	 	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	 	            numbers[row][col] = hardcodedNumbers[row][col];
	 	        
	 	         }
	 	      }
	    	  boolean[][] hardcodedIsGiven =
	 	         {{false, true, false, true, true, false, true, true, true},
	 	          {false, false, true, true, false, true, false, true, false},
	 	          {true, true, true, true, true, true, false, true, true},
	 	          {false, true, false, true, false, true, false, true, false},
	 	          {true, false, true, false, true, true, true, false, true},
	 	          {true, true, false, true, true, false, true, true, false},
	 	          {false, false, true, false, false, false, true, true, false},
	 	          {true, true, true, true, false, true, true, false, true},
	 	          {true, false, true, true, true, true, false, true, true}};
	    	  
	    	  for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	 	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	 	            isGiven[row][col] = hardcodedIsGiven[row][col];
	 	         }
	 	      }
	    	  
	      }
	      if(level == Level.medio) {
	    	  int [][] mediumcodedNumbers = 
	    		  	  {{5, 3, 4, 6, 7, 8, 9, 1, 2},
	    	          {6, 7, 2, 1, 9, 5, 3, 4, 8},
	    	          {1, 9, 8, 3, 4, 2, 5, 6, 7},
	    	          {8, 5, 9, 7, 6, 1, 4, 2, 3},
	    	          {4, 2, 6, 8, 5, 3, 7, 9, 1},
	    	          {7, 1, 3, 9, 2, 4, 8, 5, 6},
	    	          {9, 6, 1, 5, 3, 7, 2, 8, 4},
	    	          {2, 8, 7, 4, 1, 9, 6, 3, 5},
	    	          {3, 4, 5, 2, 8, 6, 1, 7, 9}};
	    	  for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
			         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
			            numbers[row][col] = mediumcodedNumbers[row][col];
			         }
			      }
	    	  boolean [][] mediumcodedIsGiven = 
		    	  		  {{false, true, false, true, false, true, true, true, false},
		    	          {true, true, true, true, true, true, true, true, false},
		    	          {true, true, false, true, true, true, false, true, true},
		    	          {false, true, true, true, true, true, true, false, true},
		    	          {false, true, true, true, true, true, true, false, false},
		    	          {true, true, false, true, false, false, true, false, true},
		    	          {true, false, true, false, true, true, true, true, true},
		    	          {true, true, true, true, true, false, true, true, true},
		    	          {true, true, false, true, true, true, true, true, false}};
	    	   for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
			         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
			            isGiven[row][col] = mediumcodedIsGiven[row][col];
			         }
			      }
	      }
	      if(level == Level.facil) {
	    	  int [][] easycodedNumbers = 
	      
	    	          {{5, 3, 4, 6, 7, 8, 9, 1, 2},
	    	          {6, 7, 2, 1, 9, 5, 3, 4, 8},
	    	          {1, 9, 8, 3, 4, 2, 5, 6, 7},
	    	          {8, 5, 9, 7, 6, 1, 4, 2, 3},
	    	          {4, 2, 6, 8, 5, 3, 7, 9, 1},
	    	          {7, 1, 3, 9, 2, 4, 8, 5, 6},
	    	          {9, 6, 1, 5, 3, 7, 2, 8, 4},
	    	          {2, 8, 7, 4, 1, 9, 6, 3, 5},
	    	          {3, 4, 5, 2, 8, 6, 1, 7, 9}};
	    	  for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
			         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
			            numbers[row][col] = easycodedNumbers[row][col];
			         }
			      }
	    	   boolean [][] easycodedIsGiven =
	 	    	          {{false, true, true, true, true, false, true, true, true},
	 	    	          {true, true, true, true, false, true, true, true, false},
	 	    	          {false, true, true, true, true, true, true, true, true},
	 	    	          {true, false, true, true, true, false, true, false, true},
	 	    	          {true, true, true, true, false, true, true, true, true},
	 	    	          {false, true, false, true, true, true, true, true, true},
	 	    	          {true, true, true, false, true, true, true, true, true},
	 	    	          {false, true, true, true, true, true, true, false, true},
	 	    	          {true, true, false, true, true, true, false, true, true}};
	    	   for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
			         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
			            isGiven[row][col] = easycodedIsGiven[row][col];
			         }
			      }
	      }

	      // Copy from hardcodedNumbers into the array "numbers"
	      //t: // Copia de hardcodedNumbers para o array "numbers"
	      
	      // Need to use input parameter cellsToGuess!
	      // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
	      //t: // Precisa usar o parâmetro de entrada cellToGuess!
	   // Codificado para teste, apenas 2 células de "8" NÃO SÃO FORNECIDAS
	     
	      // Copy from hardcodedIsGiven into array "isGiven"
	   }
	   //(For advanced students) use singleton design pattern for this class
}