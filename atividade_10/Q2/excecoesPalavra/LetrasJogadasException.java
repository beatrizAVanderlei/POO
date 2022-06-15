package excecoesPalavra;

public class LetrasJogadasException extends Exception{
    public LetrasJogadasException(char letra){
        super("A letra repetida foi "+letra);
    }
}
