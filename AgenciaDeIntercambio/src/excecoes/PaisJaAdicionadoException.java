package excecoes;

import negocio.entidades.Pais;

public class PaisJaAdicionadoException extends Exception {

    public PaisJaAdicionadoException(Pais pais) {
        super("O país " + pais.getNome() + " já foi adicionado ao repositório!");
    }
}
