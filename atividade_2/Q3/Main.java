class Main {
    public static void main (String[] args){
        Data data1 = new Data();

        data1.dia = 3;
        data1.mes = 4;
        data1.ano = 2007;

        Data data2 = new Data();

        data2.dia = 3;
        data2.mes = 4;
        data2.ano = 2007;

        data1.vemAntes(data2);
        System.out.println(data1.vemAntes(data2));
    }
}
