package employee;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;

    public BasePlusCommissionEmployee(String n1, String n2, String n, double v1, double v2, double baseSalary){
        super(n1, n2, n, v1, v2);
        if(baseSalary > 0.0)
            this.baseSalary = baseSalary;
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }
    public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "A base salarial do funcionário "+this.getFirstName()+" "+this.getLastName()+" é de "+this.getBaseSalary();
    }

    @Override
    public double earnings() {
        double lucros = this.getBaseSalary() + (this.getGrossSales()*this.getComissionRate());
        return lucros;
    }
}
