package negocio.regras;

import dados.repositórios.IRepositorioDeHospedagens;
import excecoes.CidadeNaoExisteException;
import excecoes.HospedagemJaAdicionadaException;
import excecoes.HospedagemLotadaException;
import excecoes.HospedagemNaoExisteException;
import negocio.entidades.Cidade;
import negocio.entidades.Hospedagem;

import java.io.*;
import java.util.ArrayList;

/**
 * Esta classe trata as regras de negócio relacionadas a classe Cidade.
 * Esta classe pode lançar as seguintes exceções: IOException, EOFException, FileNotFoundException, ClassNotFoundException,
 * HospedagemJaAdicionadaException, HospedagemNaoExisteException e CidadeNaoExisteException.
 *
 * @author Gabriel Viana
 */
public class NegocioHospedagem {

    private IRepositorioDeHospedagens repositorio;

    public NegocioHospedagem(IRepositorioDeHospedagens repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(Hospedagem hospedagem) throws HospedagemJaAdicionadaException, IOException {
        if (this.repositorio.existe(hospedagem)) {
            throw new HospedagemJaAdicionadaException();
        } else {
            this.repositorio.adicionar(hospedagem);
        }
    }

    public void atualizar(Hospedagem hospedagem, Hospedagem hospedagemAtualizada) throws HospedagemNaoExisteException, IOException {
        if (this.repositorio.existe(hospedagem)) {
            this.repositorio.atualizar(hospedagem, hospedagemAtualizada);
        } else {
            throw new HospedagemNaoExisteException();
        }
    }

    public void remover(Hospedagem hospedagem) throws HospedagemNaoExisteException, IOException {
        if (this.repositorio.existe(hospedagem)) {
            this.repositorio.remover(hospedagem);
        } else {
            throw new HospedagemNaoExisteException();
        }
    }

    public ArrayList<Hospedagem> recuperar() {
        return this.repositorio.recuperar();
    }

    public Hospedagem consultarHospedagem(String id) throws HospedagemNaoExisteException {
        Hospedagem hospedagem =  this.repositorio.consultarHospedagem(id);

        if (hospedagem == null) {
            throw new HospedagemNaoExisteException();
        } else {
            return hospedagem;
        }
    }

    public ArrayList<Hospedagem> procurarHospedagensPelaCidade(Cidade cidade) throws CidadeNaoExisteException {
        if (this.repositorio.procurarHospedagensPelaCidade(cidade).isEmpty()) {
            throw new CidadeNaoExisteException();
        } else {
            return this.repositorio.procurarHospedagensPelaCidade(cidade);
        }
    }

}
