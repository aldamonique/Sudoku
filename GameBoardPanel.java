package sudoku;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel{
	 private static final long serialVersionUID = 1L;  // to prevent serial warning
	
	   // Define named constants for UI sizes
	   public static final int CELL_SIZE = 60;   // Cell width/height in pixels
	   public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
	   public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
	                                             // Board width/height in pixels
	   /** The game board composes of 9x9 Cells (customized JTextFields) */
	   private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   /** It also contains a Puzzle with array numbers and isGiven */
	   private Puzzle puzzle = new Puzzle();

	   /** Constructor */
	   public GameBoardPanel() {
	      super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel

	      // Allocate the 2D array of Cell, and added into JPanel.
	      //t: Aloca o array 2D de Cell e adiciona no JPanel.
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            cells[row][col] = new Cell(row, col);
	            super.add(cells[row][col]);   // JPanel
	         }
	      }

	      // [TODO 3] Allocate a common listener as the ActionEvent listener for all the
	      //  Cells (JTextFields)
	      // .........
	      //t: Aloque um ouvinte comum como ouvinte ActionEvent para todos os
	    //Células (JTextFields)
	      CellInputListener listener = new CellInputListener();

	      // [TODO 4] Adds this common listener to all editable cells
	      // .........
	      // t: // [TODO 4] Adiciona este ouvinte comum a todas as células editáveis
	      for (int row =0; row < SudokuConstants.GRID_SIZE; ++row) {
	    	   for (int col=0; col < SudokuConstants.GRID_SIZE; ++col) {
	    	      if (cells[row][col].isEditable()) {
	    	         cells[row][col].addActionListener(listener);   // For all editable rows and cols
	    	      }
	    	   }
	    	}
	      super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
	   }

	   /**
	    * Generate a new puzzle; and reset the gameboard of cells based on the puzzle.
	    * You can call this method to start a new game.
	    */
	   //t: /** Gere um novo quebra-cabeça; e redefina o tabuleiro de células com base no quebra-cabeça.Você pode chamar este método para iniciar um novo jogo.
	  
	   public void newGame(Level level) {
	      // Generate a new puzzle
		   PlayMusic.Play(SongStatus.sudoku);
	      puzzle.newPuzzle(level);
	      // Initialize all the 9x9 cells, based on the puzzle.
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
	         }
	      }
	   }

	   /**
	    * Return true if the puzzle is solved
	    * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
	    */
	   //Retorne verdadeiro se o quebra-cabeça for resolvido ou seja, nenhuma célula tem status TO_GUESS ou WRONG_GUESS
	   public boolean isSolved() {
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
	               return false;
	            }
	         }
	      }
	      return true;
	   }

	   // [TODO 2] Define a Listener Inner Class for all the editable Cells
	   // .........
	   //t: // [TODO 2] Definir uma classe interna de ouvinte para todas as células editáveis
	// .........
		         
	   private class CellInputListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				 // Get a reference of the JTextField that triggers this action event
		    	// Obtém uma referência do JTextField que dispara este evento de ação
		         Cell sourceCell = (Cell)e.getSource();
				 
		         // Retrieve the int entered
		      // Recupera o int digitado
		         int numberIn = Integer.parseInt(sourceCell.getText());
		         

		         // For debugging
		         System.out.println("You entered " + numberIn);
		         /*
		          * [TODO 5] (later - after TODO 3 and 4)
		          * Check the numberIn against sourceCell.number.
		          * Update the cell status sourceCell.status,
		          * and re-paint the cell via sourceCell.paint().
		          *  Verifique o numberIn em relação ao sourceCell.number.
                  * Atualize o status da célula sourceCell.status,
                  * e pinte novamente a célula via sourceCell.paint().
		          */
		         
		         if (numberIn == sourceCell.number) {
		             sourceCell.status = CellStatus.CORRECT_GUESS;
		             PlayMusic.Play(SongStatus.sudoku);
		             Player.acertouCelula(); 
		            
		          }
		         else {
		         sourceCell.status = CellStatus.WRONG_GUESS; 
		         Player.errou(); 
		         }
		          sourceCell.paint();   // re-paint this cell based on its status //pinta novamente esta célula com base em seu status

		         /*
		          * [TODO 6] (later)
		          * Check if the player has solved the puzzle after this move,
		          *   by calling isSolved(). Put up a congratulation JOptionPane, if so.
		          *   Verifique se o jogador resolveu o quebra-cabeça após esta jogada,
                  * chamando isSolved(). Dê os parabéns ao JOptionPane, se for o caso.
		          */
		         if(isSolved()) {
		        	 JOptionPane.showMessageDialog(GameBoardPanel.this, 
		        			 "Parabéns!!" +  " Você venceu o jogo alcançando " + Player.getScore()+ " pontos", "Jogo resolvido!", JOptionPane.INFORMATION_MESSAGE); 
		        		
		         	}
			}
		      
		 }
}
