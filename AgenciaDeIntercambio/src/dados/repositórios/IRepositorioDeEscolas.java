package dados.repositórios;
import negocio.entidades.Cidade;
import negocio.entidades.Escolas;
import excecoes.EscolaJaAdicionadaException;
import excecoes.EscolaNaoExisteException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface representando um repositório de escolas, com os métodos básicos (adicionar, atualizar, recuperar e remover),
 * mais os método existe, consultarEscola e procurarEscolaPelaCidade.
 *
 * @author Ana Beatriz Almeida
 */

public interface IRepositorioDeEscolas {
    boolean existe(Escolas escolas);
    Escolas consultarEscola(String nome);
    void adicionarEscola(Escolas escola) throws EscolaJaAdicionadaException, IOException;
    void atualizarEscola(Escolas escola, Escolas escolaAtualizada) throws EscolaNaoExisteException, IOException;
    ArrayList<Escolas> recuperar();
    void removerEscola(Escolas escolas) throws EscolaNaoExisteException, IOException;
    ArrayList<Escolas> procurarEscolaPelaCidade(String nomeCidade);
}

