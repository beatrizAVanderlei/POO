package excecoes;

public class NomeInvalidoException extends Exception{
    public NomeInvalidoException(){
        super("O nome selecionado é inválido");
    }
}
