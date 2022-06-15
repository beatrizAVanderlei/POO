package data;
import excecoesData.*;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(){
        this.dia = 1;
        this.mes = 1;
        this.ano = 1;
    }

    public Data(int dia, int mes, int ano) throws DataInvalidaException{
        this.ano = ano;
        if((mes > 0) && (mes <= 12))
            this.mes = mes;
        else
            throw new DataInvalidaException();

        if((mes == 2) && ((dia <= 28) && (dia > 0)))
            this.dia = dia;
        else if(((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) && ((dia <= 31) && (dia > 0)))
            this.dia = dia;
        else if(((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && ((dia <= 30)  && (dia > 0)))
            this.dia = dia;
        else
            throw new DataInvalidaException();
    }

    public int getDia(){
        return this.dia;
    }
    public void setDia(int dia) throws DataInvalidaException{
        if((mes == 2) && ((dia <= 28) && (dia > 0)))
            this.dia = dia;
        else if(((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) && ((dia <= 31) && (dia>0)))
            this.dia = dia;
        else if(((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && ((dia <= 30) && (dia > 0)))
            this.dia = dia;
        else
            throw new DataInvalidaException();
    }

    public int getMes(){
        return this.mes;
    }
    public void setMes(int mes) throws DataInvalidaException{
        if((mes > 0) && (mes <= 12))
            this.mes = mes;
        else
            throw new DataInvalidaException();
    }

    public int getAno(){
        return this.ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    public boolean vemAntes (Data data){
        if(this.getAno() > data.getAno())
            return false;
        if(this.getAno() < data.getAno())
            return true;
        if((this.getAno() == data.getAno()) && (this.getMes() < data.getMes()))
            return true;
        if((this.getAno() == data.getAno()) && (this.getMes() > data.getMes()))
            return false;
        if((this.getAno() == data.getAno()) && (this.getMes() == data.getMes()) && (this.getDia() < data.getDia()))
            return true;
        if((this.getAno() == data.getAno()) && (this.getMes() == data.getMes()) && (this.getDia() > data.getDia()))
            return false;
        else
            return true;
    }

    public void imprimirData(){
        System.out.println(this.getDia()+"/"+this.getMes()+"/"+this.getAno());
    }
}
