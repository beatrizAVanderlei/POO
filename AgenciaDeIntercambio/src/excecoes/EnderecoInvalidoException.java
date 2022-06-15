package excecoes;

public class EnderecoInvalidoException extends Exception{
    public EnderecoInvalidoException(){
        super("O endereço selecionado é inválido");
    }
}
