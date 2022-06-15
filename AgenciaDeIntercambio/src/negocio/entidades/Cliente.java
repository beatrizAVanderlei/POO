package negocio.entidades;
import java.io.*;
import excecoes.CPFInvalidoException;
import excecoes.GeneroInvalidoException;
import excecoes.IdadeInvalidaException;
import excecoes.NomeInvalidoException;

/**
 * Essa classe representa dos dados pessoais de um cliente da agência.
 * Um cliente possuí um CPF(String), uma idade(int), um nome(String) e um gênero(String).
 * Essa classe pode lançar a exceção CPFInvalidoException.
 * Essa classe pode lançar a exceção NomeINvalidoException.
 * Essa classe pode lançar a exceção IdadeInvalidaException.
 * Essa classe pode lançar a exceção GeneroInvalidoException.
 * @author Ana Beatriz Almeida
 */

public class Cliente implements Serializable{
    private String nome;
    private String sobrenome;
    private String CPF;
    private String nomeCompleto;
    private int idade;
    private char genero;

    public Cliente (String sobrenome, String nome, String CPF, int idade, char genero) throws CPFInvalidoException, NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException {
        if(nome.length() > 1)
            this.nome = nome;
        else
            throw new NomeInvalidoException();

        if(sobrenome.length() > 1)
            this.sobrenome = sobrenome;
        else
            throw new NomeInvalidoException();

        if(CPF.length() == 11)
            this.CPF = CPF;
        else
            throw new CPFInvalidoException();

        if(idade >= 15)
            this.idade = idade;
        else
            throw new IdadeInvalidaException();

        this.nomeCompleto = this.nome + " " + this.sobrenome;

        genero = Character.toUpperCase(genero);
        if(Character.getType(genero) != Character.UPPERCASE_LETTER){
            throw new GeneroInvalidoException();
        } else {
            if ((genero == 'M') || (genero == 'F'))
                this.genero = genero;
            else
                throw new GeneroInvalidoException();
        }
    }

    public char getGenero(){ return genero; }
    public void setGenero(char genero) throws GeneroInvalidoException{
        genero = Character.toUpperCase(genero);
        if(Character.getType(genero) != Character.UPPERCASE_LETTER){
            throw new GeneroInvalidoException();
        } else {
            if ((genero == 'M') || (genero == 'F'))
                this.genero = genero;
            else
                throw new GeneroInvalidoException();
        }
    }

    public String getNome(){ return this.nome; }
    public void setNome(String nome) throws NomeInvalidoException{
        if(nome.length() > 1) {
            this.nome = nome;
            this.nomeCompleto = this.nome.concat(" ");
            this.nomeCompleto = this.nome.concat(this.sobrenome);
        }
        else
            throw new NomeInvalidoException();
    }

    public String getSobrenome(){ return this.sobrenome;}
    public void setSobrenome(String sobrenome) throws NomeInvalidoException{
        if(nome.length() > 1) {
            this.sobrenome = sobrenome;
            this.nomeCompleto = this.nome.concat(" ");
            this.nomeCompleto = this.nome.concat(this.sobrenome);
        }
        else
            throw new NomeInvalidoException();
    }

    public String getNomeCompleto(){return this.nomeCompleto;}

    public String getCPF(){
        return this.CPF;
    }

    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cliente){
            Cliente c = (Cliente) obj;
            return this.getCPF().equals(c.getCPF());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nomeCompleto + " - CPF: " + this.CPF + " - Idade: " + this.idade + " - Gênero: " + this.genero;
    }
}
