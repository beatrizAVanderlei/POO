package excecoes;

public class HospedagemNaoExisteException extends Exception {

    public HospedagemNaoExisteException() {
        super("Hospedagem com id não existe no repositório!");
    }
}
