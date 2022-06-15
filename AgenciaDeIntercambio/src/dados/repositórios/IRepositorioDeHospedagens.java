package dados.repositórios;

import negocio.entidades.Cidade;
import negocio.entidades.Hospedagem;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface representando um repositório de hospedagens, com os métodos básicos (adicionar, atualizar, recuperar e remover),
 * mais os métodos existe, consultarHospedagem, procurarHospedagensPelaCidade, lerArquivoDoRepositorio.
 *
 * @author Gabriel Viana
 */
public interface IRepositorioDeHospedagens {

    void adicionar(Hospedagem hospedagem) throws IOException;
    void atualizar(Hospedagem hospedagem, Hospedagem hospedagemAtualizada) throws IOException;
    ArrayList<Hospedagem> recuperar();
    void remover(Hospedagem hospedagem) throws IOException;
    boolean existe(Hospedagem hospedagem);
    Hospedagem consultarHospedagem(String id);
    ArrayList<Hospedagem> procurarHospedagensPelaCidade(Cidade cidade);

}
