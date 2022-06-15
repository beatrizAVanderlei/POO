package negocio.regras;
import dados.repositórios.IRepositorioDeClientes;
import excecoes.*;
import negocio.entidades.Cliente;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Essa classe trata as regras de negócio relacionadas a classe Cliente.
 * Pode lançar as exceções: IOException, ClassNotFoundException, ClienteJaAdicionadoException,
 * ClienteNaoExisteException
 *
 * @author Ana Beatriz Almeida
 */

public class NegocioClientes {
    private IRepositorioDeClientes repositorio;

    public NegocioClientes (IRepositorioDeClientes repositorioDeClientes){
        this.repositorio = repositorioDeClientes;
    }

    public void adicionar(Cliente cliente) throws ClienteJaAdicionadoException, IOException {
        if(!this.repositorio.existe(cliente))
            this.repositorio.adicionarCliente(cliente);
        else
            throw new ClienteJaAdicionadoException(cliente);
    }

    public Cliente consultarCliente(String CPF) throws ClienteNaoExisteException{
        Cliente cliente = this.repositorio.consultarCliente(CPF);

        if(cliente == null)
            throw new ClienteNaoExisteException();
        else
            return cliente;
    }

    public ArrayList<Cliente> recuperar(){
        return this.repositorio.recuperar();
    }

    public void remover(Cliente cliente) throws ClienteNaoExisteException, IOException{
        if(this.repositorio.existe(cliente))
            this.repositorio.removerCliente(cliente);
        else
            throw new ClienteNaoExisteException();
    }

    public void atualizar(Cliente cliente, Cliente clienteAtualizado) throws ClienteNaoExisteException, IOException{
        if(this.repositorio.existe(cliente))
            this.repositorio.atualizarCliente(cliente, clienteAtualizado);
        else
            throw new ClienteNaoExisteException();
    }
}
