package pessoa;

public class Conhecido extends Pessoa {
    private String email;

    public Conhecido(){}
    public Conhecido(String n, int i, String email){
        super(n, i);
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Conhecido{" +
                "email='" + email + '\'' +
                '}';
    }
}
