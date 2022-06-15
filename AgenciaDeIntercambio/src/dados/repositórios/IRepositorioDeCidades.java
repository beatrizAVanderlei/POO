package dados.repositórios;

import negocio.entidades.Cidade;
import negocio.entidades.Pais;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface representando um repositório de cidades, com os métodos básicos (adicionar, atualizar, recuperar e remover),
 * mais os métodos consultarCidade, existe, procurarCidadesPeloPais e lerArquivoDoRepositorio.
 *
 * @author Gabriel Viana
 */
public interface IRepositorioDeCidades {

    void adicionar(Cidade cidade) throws IOException;
    void atualizar(Cidade cidade, Cidade cidadeAtualizada) throws IOException;
    ArrayList<Cidade> recuperar();
    void remover(Cidade cidade) throws IOException;
    Cidade consultarCidade(String nome);
    boolean existe(Cidade cidade);
    ArrayList<Cidade> procurarCidadesPeloPais(Pais pais);
}
