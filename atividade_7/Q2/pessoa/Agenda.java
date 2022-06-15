package pessoa;

public class Agenda {
    Pessoa[] contatos;
    private int tamanho;
    private int quantidadeAmigos = 0;
    private int quantidadeConhecidos = 0;
    private int quantidadeContatos = 0;

    public Agenda(int i){
        this.tamanho = i;
        this.contatos = new Pessoa[this.tamanho];
    }

    public void adicionar (Pessoa pessoa){
        if(quantidadeContatos < this.tamanho) {
            this.contatos[quantidadeContatos] = pessoa;
        }
        quantidadeContatos++;
    }

    public Pessoa[] getContatos(){
        return this.contatos;
    }

    public int getQuantidadeAmigos(){
        for(int i = 0; i < quantidadeContatos; i++) {
            if (this.contatos[i] instanceof Amigos) {
                quantidadeAmigos++;
            }
        }
        return quantidadeAmigos;
    }

    public int getQuantidadeConhecidos(){
            for(int i = 0; i < quantidadeContatos; i++) {
                if (this.contatos[i] instanceof Conhecido) {
                    quantidadeConhecidos++;
                }
            }
        return quantidadeConhecidos;
    }

    public int getQuantidadeContatos(){
        return quantidadeContatos;
    }

}

