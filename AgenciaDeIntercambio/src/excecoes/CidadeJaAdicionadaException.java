package excecoes;

import negocio.entidades.Cidade;

/**
 * Exceção criada para tratar o caso em que há uma tentativa de adicionar uma cidade repetida no repositório.
 */
public class CidadeJaAdicionadaException extends Exception {

    public CidadeJaAdicionadaException(Cidade cidade) {
        super("A cidade " + cidade.getNome() + " já foi adicionada no repositório!");
    }
}
