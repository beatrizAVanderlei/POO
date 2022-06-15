package excecoes;

public class ClienteNaoExisteException extends Exception{
    public ClienteNaoExisteException(){
        super("O cliente não está registrado");
    }
}
