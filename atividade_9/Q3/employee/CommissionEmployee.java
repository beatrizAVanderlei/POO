package employee;

public class CommissionEmployee extends Employee{
    private double grossSales;
    private double comissionRate;

    public CommissionEmployee(String n1, String n2, String n, double grossSales, double comissionRate){
        super(n1, n2, n);
        if(grossSales > 0.0)
            this.grossSales = grossSales;
        if((comissionRate > 0.0) && (comissionRate <= 1.0))
            this.comissionRate = comissionRate;
    }

    public double getGrossSales(){
        return this.grossSales;
    }
    public void setGrossSales(double grossSales){
        this.grossSales = grossSales;
    }

    public double getComissionRate(){
        return this.comissionRate;
    }
    public void setComissionRate(double comissionRate){
        this.comissionRate = comissionRate;
    }

    @Override
    public String toString() {
        return "O salario grosso do funcionario "+this.getFirstName()+" "+this.getLastName()+" é "+this.getGrossSales()+"e sua comissão é"+this.getComissionRate();
    }

    @Override
    public double earnings(){
        double lucros = this.getComissionRate()*this.getGrossSales();
        return lucros;
    }

}
