package contas;
import java.util.ArrayList;

public class RepositorioContas {
    private ArrayList<Conta> contas = new ArrayList<>();

    public RepositorioContas(){
        this.contas = new ArrayList<>();
    }

    public void adiconarConta (Conta conta){

        if(this.contas.contains(conta) == false){
            this.contas.add(conta);
        }
        else{
            System.out.println("A conta já está cadastrada");
        }
    }

    public void removerConta (Conta conta){

        if (this.contas.contains(conta) == true){
            this.contas.remove(conta);
        }
        else{
            System.out.println("A conta selecionada não existe");
        }
    }

    public void atualizarConta (Conta conta, Conta contaAtualizada){
        //conta carrega informações antigas no sistema, contaAtualizada carrega novas informações
        if(this.contas.contains(conta) == true){
            this.contas.set(this.contas.indexOf(conta), contaAtualizada);
        }
        else{
            System.out.println("A conta selecionada não existe");
        }
    }

    public void recuperarConta(Conta conta) {
        if (this.contas.contains(conta) == true) {
            System.out.println("A conta recuperada foi a "+conta.getCodigo());
        }
        else{
            System.out.println("A conta não está registrada");
        }
    }
        public ArrayList<Conta> recuperar () {
            return contas;
        }


}
