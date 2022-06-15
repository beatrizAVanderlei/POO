package employee;

public abstract class Employee implements Measurable{
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String name1, String name2, String number){
        this.firstName = name1;
        this.lastName = name2;
        this.socialSecurityNumber = number;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getSocialSecurityNumber(){
        return this.socialSecurityNumber;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "O empregado "+this.getFirstName()+" "+this.getLastName()+" tem o numero de segurança "+this.getSocialSecurityNumber();
    }

    @Override
    public double getMeasure() {
        return earnings();
    }
}
