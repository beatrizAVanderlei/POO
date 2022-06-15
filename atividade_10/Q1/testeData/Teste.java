package testeData;
import excecoesData.*;
import data.*;

public class Teste {
    public static void main(String[] args) throws Exception{
        Data data1 = new Data();
        Data data2 = new Data();
        try{
            data1.setAno(1978);
            data1.setMes(11);
            data1.setDia(4);
            data2.setAno(2000);
        } catch(DataInvalidaException e){
            System.out.println(e.getMessage());
        }
        System.out.println(data1.vemAntes(data2));
        data1.imprimirData();
    }
}
