package excecoes;

public class IdadeInvalidaException extends Exception{
    public IdadeInvalidaException(){
        super("Idade selecionada inválida");
    }
}
