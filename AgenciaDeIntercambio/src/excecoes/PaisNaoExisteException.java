package excecoes;

import negocio.entidades.Pais;

public class PaisNaoExisteException extends Exception {

    public PaisNaoExisteException() {
        super("O pais não existe no repositório!");
    }
}
