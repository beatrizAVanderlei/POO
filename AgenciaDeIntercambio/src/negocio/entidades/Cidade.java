package negocio.entidades;

import java.io.Serializable;

/**
 * Esta classe representa uma cidade para qual o intercambista pode ir.
 * Uma cidade possui um pais (classe Pais) e um nome (String).
 *
 * @author Gabriel Viana
 */
public class Cidade implements Serializable {
    private Pais pais;
    private String nome;

    public Cidade(Pais pais, String nome) {
        this.pais = pais;
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cidade) {
            Cidade cidade = (Cidade) obj;

            return this.getNome().equalsIgnoreCase(cidade.getNome()) && this.getPais().equals(cidade.getPais());
        }

        return false;
    }

    @Override
    public String toString() {
        return "Cidade: " + this.nome + " - País: " + this.pais.getNome();
    }
}
