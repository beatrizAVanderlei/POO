package dados.repositórios;
import excecoes.*;
import negocio.entidades.Cidade;
import negocio.entidades.Escolas;
import negocio.entidades.Pais;

import java.util.ArrayList;
import java.io.*;

/**
 * A classe representa o repositório de escolas, implementa a interface IRepositorioDeEscolas e armazena os
 * dados de forma persistente em arquivos .dat. Essa classe pode lançar as exceções de manipulação de arquivo:
 * IOException, FileNotFoundException, EOFException e ClassNotFoundException.
 *
 * @author Ana Beatriz Almeida
 */

public class RepositorioDeEscolas implements IRepositorioDeEscolas {
    private ArrayList<Escolas> escolas;
    private static final String nomeDoArquivo = "repositorioDeEscolas.dat";

    public RepositorioDeEscolas() {
        this.escolas = new ArrayList<Escolas>();
        try {
            lerArquivoDoRepositorio();

        } catch (FileNotFoundException fnde) {
            adicionarEscolaDefault();

        } catch (EOFException eofe) {
            adicionarEscolaDefault();

        } catch (IOException ioe) {
            adicionarEscolaDefault();

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarEscolaDefault(){
        try {
            Pais pais = new Pais("EUA", "Inglês", 2000);
            Cidade cidade = new Cidade(pais, "New York");
            Escolas escola = new Escolas (cidade, "daltonschool@gmail.com", "108 E 89th St, New York, NY 10128", "Dalton School", 1000, 300);
            this.escolas.add(escola);
        } catch (PrecoDaPassagemInvalidoException e) {
            System.err.println(e.getMessage());
        } catch (EmailInvalidoException e) {
            System.err.println(e.getMessage());
        } catch (QuantidadeDeAlunosInvalidaException e) {
            System.err.println(e.getMessage());
        } catch (MensalidadeInvalidaException e) {
            System.err.println(e.getMessage());
        } catch (EnderecoInvalidoException e) {
            System.err.println(e.getMessage());
        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean existe(Escolas escolas) {
        if(this.escolas.contains(escolas))
            return true;
        else
            return false;
    }


    public Escolas consultarEscola(String nome) {
        Escolas escola = null;

        for(Escolas e : this.escolas){
            if(e.getNome().equalsIgnoreCase(nome))
                escola = e;
        }
        return escola;
    }

    public void adicionarEscola(Escolas escola) throws IOException {
            this.escolas.add(escola);
            salvarRepositorioNoArquivo();
    }

    public void atualizarEscola(Escolas escola, Escolas escolaAtualizada) throws IOException {
            this.escolas.set(this.escolas.indexOf(escola), escolaAtualizada);
            salvarRepositorioNoArquivo();
    }

    public ArrayList<Escolas> recuperar() {
        return this.escolas;
    }

    public void removerEscola(Escolas escolas) throws IOException {
            this.escolas.remove(escolas);
            salvarRepositorioNoArquivo();
    }

    public ArrayList<Escolas> procurarEscolaPelaCidade(String cidade) {
        ArrayList<Escolas> escolas = new ArrayList<>();
        for(Escolas c: this.escolas){
            if(c.getCidade().getNome().equalsIgnoreCase(cidade)){
                escolas.add(c);
            }
        }
        return escolas;
    }

    private void lerArquivoDoRepositorio() throws IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
        ObjectInputStream inputStream = new ObjectInputStream(arquivo);
        this.escolas = (ArrayList<Escolas>) inputStream.readObject();
        inputStream.close();
    }

    private void salvarRepositorioNoArquivo() throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
        ObjectOutputStream outputStream = new ObjectOutputStream(arquivo);
        outputStream.writeObject(this.escolas);
        outputStream.close();

    }
}

