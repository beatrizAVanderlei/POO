package dados.repositórios;
import negocio.entidades.*;
import excecoes.ContaJaAdicionadaException;
import excecoes.ContaNaoExisteException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface representando um repositório de contas, com os métodos básicos (adicionar, atualizar, recuperar e remover),
 * mais os método existe e consultarConta.
 *
 * @author Ana Beatriz Almeida
 */

public interface IRepositorioDeContas {
    Conta consultarConta(String CPF) throws ContaNaoExisteException;
    boolean existe(Conta conta);
    void adicionarConta(Conta conta) throws ContaJaAdicionadaException, IOException;
    void atualizarConta(Conta conta, Conta contaAtualizada) throws ContaNaoExisteException, IOException;
    ArrayList<Conta> recuperar();
    void removerConta(Conta conta) throws ContaNaoExisteException, IOException;
}
