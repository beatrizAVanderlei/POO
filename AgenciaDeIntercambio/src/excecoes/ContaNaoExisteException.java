package excecoes;
import negocio.entidades.Conta;

public class ContaNaoExisteException extends Exception{

    public ContaNaoExisteException(){
        super("A conta do cliente não existe nos registros.");
    }
}
