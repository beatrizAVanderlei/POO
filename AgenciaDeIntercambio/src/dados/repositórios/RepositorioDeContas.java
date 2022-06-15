package dados.repositórios;
import negocio.entidades.Cliente;
import negocio.entidades.Conta;
import java.util.ArrayList;
import java.io.*;

/**
 * A classe representa o repositório de contas, implementa a interface IRepositorioDeContas e armazena os
 * dados de forma persistente em arquivos .dat. Essa classe pode lançar as exceções de manipulação de arquivo:
 * IOException, FileNotFoundException, EOFException e ClassNotFoundException.
 *
 * @author Ana Beatriz Almeida
 */

public class RepositorioDeContas implements IRepositorioDeContas{
    private ArrayList<Conta> contas;
    private static final String nomeDoArquivo = "repositorioDeContas.dat";

    public RepositorioDeContas(){
        this.contas = new ArrayList<Conta>();

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

    public boolean existe(Conta conta){
        if(this.contas.contains(conta))
            return true;
        else
            return false;
    }

    public void removerConta (Conta conta) throws IOException{
            this.contas.remove(conta);
            salvarRepositorioNoArquivo();
    }

    public void adicionarConta(Conta conta) throws IOException {
            this.contas.add(conta);
            salvarRepositorioNoArquivo();
    }

    public void atualizarConta(Conta conta, Conta contaAtualizada) throws IOException{
            this.contas.set(this.contas.indexOf(conta), contaAtualizada);
            salvarRepositorioNoArquivo();
    }

    public ArrayList<Conta> recuperar(){
        return this.contas;
    }

    public Conta consultarConta(String CPF){
        Conta conta = null;
        for(Conta c : this.contas){
            if(c.getCliente().getCPF().equalsIgnoreCase(CPF)) {
                conta = c;
                break;
            }
        }
        return conta;
    }

    private void lerArquivoDoRepositorio() throws IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
        ObjectInputStream inputStream = new ObjectInputStream(arquivo);
        this.contas = (ArrayList<Conta>) inputStream.readObject();
        inputStream.close();
    }

    private void salvarRepositorioNoArquivo() throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
        ObjectOutputStream outputStream = new ObjectOutputStream(arquivo);
        outputStream.writeObject(this.contas);
        outputStream.close();

    }

}

