class Q3 {
    public static void main (String[] args){
        int valor = 196, troco, cem, cinquenta, dez, cinco, um;
        troco = valor;

        cem = troco/100;
        troco = troco - (cem*100);

        cinquenta = troco/50;
        troco = troco - (cinquenta*50);

        dez = troco/10;
        troco = troco - (dez*10);

        cinco = troco/5;
        troco = troco - (cinco*5);

        um = troco;

        System.out.printf("Possui %d cedulas de 100\n", cem);
        System.out.printf("Possui %d cedulas de 50\n", cinquenta);
        System.out.printf("Possui %d cedulas de 10\n", dez);
        System.out.printf("Possui %d cedulas de 5\n", cinco);
        System.out.printf("Possui %d cedulas de 1\n", um);
    }
}
