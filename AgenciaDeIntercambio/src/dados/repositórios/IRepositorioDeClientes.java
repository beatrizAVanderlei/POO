package dados.repositórios;
import excecoes.*;
import negocio.entidades.Cliente;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface representando um repositório de contas, com os métodos básicos (adicionar, atualizar, recuperar e remover),
 * mais os métodos consultarCliente e existe.
 *
 * @author Ana Beatriz Almeida
 */

public interface IRepositorioDeClientes {
    boolean existe(Cliente cliente);
    void adicionarCliente(Cliente conta) throws ClienteJaAdicionadoException, IOException;
    void atualizarCliente(Cliente conta, Cliente contaAtualizada) throws ClienteNaoExisteException, IOException;
    ArrayList<Cliente> recuperar();
    void removerCliente(Cliente conta) throws ClienteNaoExisteException, IOException;
    Cliente consultarCliente(String CPF);
}