class Pessoa {
    String nome;
    int idade;
    double peso, altura;

    public void crescer_e_envelhecer(int idade_a_mais){
        if (this.idade + idade_a_mais >= 21){ //só se pode crescer até menos que 21 anos
            this.altura = altura;
        }
        else{
            this.altura = altura + 0.5;
        }
        this.idade += idade_a_mais;
    }

    public void emagrecer(double peso_a_menos){
        this.peso -= peso_a_menos;
    }

    public void engordar(double peso_a_mais){
        this.peso += peso_a_mais;
    }


}
