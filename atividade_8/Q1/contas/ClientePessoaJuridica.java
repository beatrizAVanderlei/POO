package contas;

public class ClientePessoaJuridica extends Conta{
    private String CNPJ;

    public ClientePessoaJuridica(String n, double s, String CNPJ){
        super(n, s);
        this.CNPJ = CNPJ;
    }

    public String getCNPJ(){
        return this.CNPJ;
    }
    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }

    @Override
    public String getCodigo(){
        return this.getCNPJ();
    }

}
