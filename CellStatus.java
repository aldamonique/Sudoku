package sudoku;
/**
 * An enumeration of constants to represent the status
 * of each cell.
 */
//t: Uma enumeração de constantes para representar o status de cada célula.

public enum CellStatus {
	GIVEN,         // clue, no need to guess
	TO_GUESS,      // need to guess - not attempted yet
	CORRECT_GUESS, // need to guess - correct guess
	WRONG_GUESS    // need to guess - wrong guess
	      // The puzzle is solved if none of the cells have 
	      //  status of TO_GUESS or WRONG_GUESS
     //t: DADO, // pista, não há necessidade de adivinhar
	 // preciso adivinhar - ainda não tentei
	// preciso adivinhar - adivinhar corretamente
	// preciso adivinhar - palpite errado
	// O quebra-cabeça é resolvido se nenhuma das células tiver
	// status de TO_GUESS ou WRONG_GUESS
}
