package sudoku;

public class Player {
	private static String nome; 
	private static int score; 
	private static int erros;
	
	Player() {
	}
	public static String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		Player.nome = nome;
	}
	
	public static int getScore() {
		return score;
	}
	public void setScore(int score) {
		Player.score = score;
	}
	public static int getErros() {
		return erros;
	}
	public void setErros(int erros) {
		Player.erros = erros;
	}
	public static void acertouCelula() {
        score += 15;
        SudokuMain.getInstance().updateScoreLabel(); 
    }
	public static void resetScore() {
		score = 0;  
		SudokuMain.getInstance().updateScoreLabel(); 
	}
	public static void errou() {
        erros += 1;
        SudokuMain.getInstance().updateErroLabel(); 
    }
    
    public static void restartErro() {
        erros = 0; 
    }
	public String toString() {
		return "Jogador: " + nome;
	}
}
