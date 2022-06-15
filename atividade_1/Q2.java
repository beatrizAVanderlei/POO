class Q2 {
    public static void main (String[] args){
        double investimento = 10000;
        double juros = 0.1; // juros de 10%
        double mes, total;

        total = investimento;

        for (int i = 1; i < 13; i++){
            mes = total * juros;
            total = mes + total;
        }

        System.out.println("Saldo o investimento após 1 ano: " +total);

    }
}
