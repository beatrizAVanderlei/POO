package testeAgenda;
import pessoa.*;
public class Teste {
    public static void main(String[] args) {
        Agenda contatos = new Agenda(20);
        Conhecido c = new Conhecido("juliano", 19, "juliandovvvv@gmail.com");
        Amigos a = new Amigos("bebebe", 13, "12/03");

        contatos.adicionar(c);
        contatos.adicionar(a);

        System.out.println("Na agenda tem "+contatos.getQuantidadeAmigos()+" amigo(s), "+contatos.getQuantidadeConhecidos()+" conhecido(s) e "+contatos.getQuantidadeContatos()+" contato(s)");

        Pessoa[] lista = contatos.getContatos();
        for(int i = 0; i < contatos.getQuantidadeContatos(); i++){
            if (lista[i] instanceof Conhecido) {
                System.out.println("Nome: "+((Conhecido) lista[i]).getNome()+ " - "+((Conhecido) lista[i]).getEmail());
            } else {
                System.out.println("Nome: "+((Amigos) lista[i]).getNome()+ " - "+((Amigos) lista[i]).getAniversario());
            }
        }

    }
}
