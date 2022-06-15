package excecoes;

import negocio.entidades.Cidade;

public class CidadeNaoExisteException extends Exception {

    public CidadeNaoExisteException() {
        super("A cidade não existe no repositório!");
    }
}
