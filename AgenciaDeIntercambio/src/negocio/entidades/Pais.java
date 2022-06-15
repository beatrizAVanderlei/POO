package negocio.entidades;

import excecoes.PrecoDaPassagemInvalidoException;

import java.io.Serializable;

/**
 * Esta classe representa um país para qual o intercambista pode ir.
 * Um país possui um nome (String), o idioma oficial (String) e o preço da passagem para esse país (double).
 * Esta classe pode lançar a exceção PrecoDaPassagemInvalidoException, se o preço da passagem assumir valor menor ou igual a zero.
 *
 * @author Gabriel Viana
 */
public class Pais implements Serializable {
    private String nome;
    private String idiomaOficial;
    private double precoDaPassagemIdaVolta;

    public Pais(String nome, String idiomaOficial, double precoDaPasssagem) throws PrecoDaPassagemInvalidoException {
        this.nome = nome;
        this.idiomaOficial = idiomaOficial;
        if (precoDaPasssagem > 0) {
            this.precoDaPassagemIdaVolta = precoDaPasssagem;
        } else {
            throw new PrecoDaPassagemInvalidoException();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdiomaOficial() {
        return idiomaOficial;
    }

    public void setIdiomaOficial(String idiomaOficial) {
        this.idiomaOficial = idiomaOficial;
    }

    public double getPrecoDaPassagemIdaVolta() {
        return precoDaPassagemIdaVolta;
    }

    public void setPrecoDaPassagemIdaVolta(double precoDaPassagemIdaVolta) throws PrecoDaPassagemInvalidoException {
        if (precoDaPassagemIdaVolta > 0) {
            this.precoDaPassagemIdaVolta = precoDaPassagemIdaVolta;
        } else {
            throw new PrecoDaPassagemInvalidoException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pais) {
            Pais pais = (Pais) obj;

            return this.getNome().equalsIgnoreCase(pais.getNome());
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("País: %s - Idioma: %s - Preço da passagem: R$ %.2f", this.nome, this.idiomaOficial, this.precoDaPassagemIdaVolta);
    }
}
