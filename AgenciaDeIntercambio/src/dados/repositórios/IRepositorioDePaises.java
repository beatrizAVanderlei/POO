package dados.repositórios;

import negocio.entidades.Pais;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface representando um repositório de países, com os métodos básicos (adicionar, atualizar, recuperar e remover),
 * mais os método existe, consultarPais, consultarIdiomasDosPaises, procurarPaisPeloIdioma e lerArquivoDoRepositorio.
 *
 * @author Gabriel Viana
 */
public interface IRepositorioDePaises {

    void adicionar(Pais pais) throws IOException;
    void atualizar(Pais pais, Pais paisAtualizado) throws IOException;
    ArrayList<Pais> recuperar();
    void remover(Pais pais) throws IOException;
    boolean existe(Pais pais);
    public Pais consultarPais(String nome);
    ArrayList<String> consultarIdiomaDosPaises();
    ArrayList<Pais> procurarPaisPeloIdioma(String idioma);
}
