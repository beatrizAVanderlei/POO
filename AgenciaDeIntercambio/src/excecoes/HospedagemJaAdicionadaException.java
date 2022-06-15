package excecoes;

public class HospedagemJaAdicionadaException extends Exception {

    public HospedagemJaAdicionadaException() {
        super("Hospedagem com id já foi adicionada no repositório!");
    }
}
