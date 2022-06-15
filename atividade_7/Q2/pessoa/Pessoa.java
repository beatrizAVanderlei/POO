package pessoa;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(){}
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(){
        this.nome = nome;
    }

    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
