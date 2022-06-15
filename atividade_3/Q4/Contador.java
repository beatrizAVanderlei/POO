public class Contador {
    private int contador;

    public void Contador(int contador){
        this.contador = contador;
    }
    public void Contador(){
        this.contador = 0;
    }
    public void zerar(){
        this.contador = 0;
    }
    public void incrementar(){
        this.contador++;
    }
    public int consultar(){
        return this.contador;
    }

}
