package excecoes;

public class EmailInvalidoException extends Exception{
    public EmailInvalidoException(){
        super("O email selecionado é inválido");
    }
}
