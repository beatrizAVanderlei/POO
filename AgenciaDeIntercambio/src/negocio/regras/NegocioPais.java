package negocio.regras;

import dados.repositórios.IRepositorioDePaises;
import excecoes.IdiomaNaoEncontradoException;
import excecoes.PaisJaAdicionadoException;
import excecoes.PaisNaoExisteException;
import negocio.entidades.Pais;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta classe trata as regras de negócio relacionadas a classe Cidade.
 * Esta classe pode lançar as seguintes exceções: IOException, EOFException, FileNotFoundException, ClassNotFoundException,
 * PaisJaAdicionadaException, PaisNaoExisteException e IdiomaNaoEncontradoException.
 *
 * @author Gabriel Viana
 */
public class NegocioPais {

    private IRepositorioDePaises repositorio;

    public NegocioPais(IRepositorioDePaises repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(Pais pais) throws PaisJaAdicionadoException, IOException {
        if (this.repositorio.existe(pais)) {
            throw new PaisJaAdicionadoException(pais);
        } else {
            this.repositorio.adicionar(pais);
        }
    }

    public void atualizar(Pais pais, Pais paisAtualizado) throws PaisNaoExisteException, IOException {
        if (this.repositorio.existe(pais)) {
            this.repositorio.atualizar(pais, paisAtualizado);
        } else {
            throw new PaisNaoExisteException();
        }
    }

    public void remover(Pais pais) throws PaisNaoExisteException, IOException {
        if (this.repositorio.existe(pais)) {
            this.repositorio.remover(pais);
        } else {
            throw new PaisNaoExisteException();
        }
    }

    public ArrayList<Pais> recuperar() {
        return this.repositorio.recuperar();
    }

    public Pais consultarPais(String nome) throws PaisNaoExisteException {
        Pais pais = this.repositorio.consultarPais(nome);

        if (pais == null) {
            throw new PaisNaoExisteException();
        } else {
            return pais;
        }
    }

    public ArrayList<String> consultarIdiomaDosPaises() {
        return this.repositorio.consultarIdiomaDosPaises();
    }

    public ArrayList<Pais> procurarPaisPeloIdioma(String idioma) throws IdiomaNaoEncontradoException {
        if (this.repositorio.procurarPaisPeloIdioma(idioma).isEmpty()) {
            throw new IdiomaNaoEncontradoException();
        } else {
            return this.repositorio.procurarPaisPeloIdioma(idioma);
        }
    }

}
