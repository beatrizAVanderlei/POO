package contas;

public class ClientePessoaFisica extends Conta{
    private String CPF;

    public ClientePessoaFisica(String n, double s, String CPF){
        super(n, s);
        this.CPF = CPF;
    }

    public String getCPF(){
        return this.CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    @Override
    public String getCodigo(){
        return this.getCPF();
    }
}
