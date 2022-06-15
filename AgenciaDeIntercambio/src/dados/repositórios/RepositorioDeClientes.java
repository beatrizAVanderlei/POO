package dados.repositórios;
import negocio.entidades.Cliente;
import java.io.*;
import java.util.ArrayList;

/**
 * A classe representa o repositório de contas, implementa a interface IRepositorioDeClientes e armazena os
 * dados de forma persistente em arquivos .dat. Essa classe pode lançar as exceções de manipulação de arquivo:
 * IOException, FileNotFoundException, EOFException e ClassNotFoundException.
 *
 * @author Ana Beatriz Almeida
 */

public class RepositorioDeClientes implements IRepositorioDeClientes{
    private ArrayList<Cliente> clientes;
    private static final String nomeDoArquivo = "repositorioDeClientes.dat";

    public RepositorioDeClientes(){
        this.clientes = new ArrayList<Cliente>();

        try{
            lerArquivoDoRepositorio();
        } catch (FileNotFoundException fnde){
            System.err.println(fnde.getMessage());
        } catch (EOFException e){
            System.err.println(e.getMessage());
        } catch (IOException i){
            System.err.println(i.getMessage());
        } catch (ClassNotFoundException cnfe){
            System.err.println(cnfe.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean existe(Cliente cliente){
        if(this.clientes.contains(cliente))
            return true;
        else
            return false;
    }

    public void adicionarCliente(Cliente cliente) throws IOException {
            this.clientes.add(cliente);
            salvarRepositorioNoArquivo();
    }

    public void atualizarCliente(Cliente cliente, Cliente clienteAtualizado) throws IOException {
            this.clientes.set(this.clientes.indexOf(cliente), clienteAtualizado);
            salvarRepositorioNoArquivo();
    }

    public ArrayList<Cliente> recuperar() {
        return this.clientes;
    }

    public void removerCliente(Cliente cliente) throws IOException {
            this.clientes.remove(cliente);
            salvarRepositorioNoArquivo();
    }

    public Cliente consultarCliente(String CPF){
        Cliente cliente = null;

        for(Cliente c : this.clientes){
            if(c.getCPF().equalsIgnoreCase(CPF)){
                cliente = c;
                break;
            }
        }
        return cliente;
    }

    private void lerArquivoDoRepositorio() throws IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
        ObjectInputStream inputStream = new ObjectInputStream(arquivo);
        this.clientes = (ArrayList<Cliente>) inputStream.readObject();
        inputStream.close();
    }


    private void salvarRepositorioNoArquivo() throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
        ObjectOutputStream outputStream = new ObjectOutputStream(arquivo);
        outputStream.writeObject(this.clientes);
        outputStream.close();

    }
}

