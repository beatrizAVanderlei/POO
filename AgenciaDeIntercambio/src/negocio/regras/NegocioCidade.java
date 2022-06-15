package negocio.regras;

import dados.repositórios.IRepositorioDeCidades;
import excecoes.CidadeJaAdicionadaException;
import excecoes.CidadeNaoExisteException;
import excecoes.PaisNaoExisteException;
import negocio.entidades.Cidade;
import negocio.entidades.Pais;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta classe trata as regras de negócio relacionadas a classe Cidade.
 * Esta classe pode lançar as seguintes exceções: IOException, EOFException, FileNotFoundException, ClassNotFoundException,
 * CidadeJaAdicionadaException, CidadeNaoExisteException e PaisNaoExisteException.
 *
 * @author Gabriel Viana
 */
public class NegocioCidade {
    private IRepositorioDeCidades repositorio;

    public NegocioCidade(IRepositorioDeCidades repositorio) {
        this.repositorio = repositorio;
    }

    public void adcionar(Cidade cidade) throws CidadeJaAdicionadaException, IOException {
        if (this.repositorio.existe(cidade)) {
            throw new CidadeJaAdicionadaException(cidade);
        } else {
            this.repositorio.adicionar(cidade);
        }
    }

    public void atualizar(Cidade cidade, Cidade cidadeAtualizada) throws CidadeNaoExisteException, IOException {
        if (this.repositorio.existe(cidade)) {
            this.repositorio.atualizar(cidade, cidadeAtualizada);
        } else {
            throw new CidadeNaoExisteException();
        }
    }

    public void remover(Cidade cidade) throws CidadeNaoExisteException, IOException {
        if (this.repositorio.existe(cidade)) {
            this.repositorio.remover(cidade);
        } else {
            throw new CidadeNaoExisteException();
        }
    }

    public ArrayList<Cidade> recuperar() {
        return this.repositorio.recuperar();
    }

    public Cidade consultarCidade(String nome) throws CidadeNaoExisteException {
        Cidade cidade = this.repositorio.consultarCidade(nome);

        if (cidade == null) {
            throw new CidadeNaoExisteException();
        } else {
            return cidade;
        }
    }

    public ArrayList<Cidade> procurarCidadesPeloPais(Pais pais) throws PaisNaoExisteException {
        if (this.repositorio.procurarCidadesPeloPais(pais).isEmpty()) {
            throw new PaisNaoExisteException();
        } else {
            return this.repositorio.procurarCidadesPeloPais(pais);
        }
    }
}
