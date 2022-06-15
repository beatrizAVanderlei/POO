package pessoa;

public class Amigos extends Pessoa{
    private String aniversario;

    public Amigos(){}
    public Amigos(String n, int i, String aniversario){
        super(n, i);
        this.aniversario = aniversario;
    }

    public String getAniversario(){
        return this.aniversario;
    }
    public void setAniversario(String aniversario){
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "Amigos{" +
                "aniversario='" + aniversario + '\'' +
                '}';
    }
}
