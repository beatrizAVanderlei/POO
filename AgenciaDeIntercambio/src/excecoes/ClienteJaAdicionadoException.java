package excecoes;
import negocio.entidades.Cliente;

public class ClienteJaAdicionadoException extends Exception{
    public ClienteJaAdicionadoException(Cliente cliente){
        super("O cliente "+cliente.getCPF()+" já foi adicionado");
    }
}
