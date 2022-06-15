package excecoes;
import negocio.entidades.Conta;

public class ContaJaAdicionadaException extends Exception{
    public ContaJaAdicionadaException(Conta conta){
        super("A conta do cliente" + conta.getCliente().getNome()+" já foi adicionada nos registros.");
    }
}
