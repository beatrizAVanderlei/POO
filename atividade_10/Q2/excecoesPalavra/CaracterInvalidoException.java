package excecoesPalavra;

public class CaracterInvalidoException extends Exception{
    public CaracterInvalidoException(){
        super("Caracter digitado é inválido, digite uma letra");
    }
}
