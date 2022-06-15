class Q1 {
    public static void main (String[] args){
        int fixo = 200;
        double vendedor_1 = 239.99;
        double vendedor_2 = 129.75;
        double vendedor_3 = 99.95;
        double vendedor_4 = 350.89;

        vendedor_1 *= 0.09;
        vendedor_1 += fixo;

        vendedor_2 *= 0.09;
        vendedor_2 += fixo;

        vendedor_3 *= 0.09;
        vendedor_3 += fixo;

        vendedor_4 *= 0.09;
        vendedor_4 += fixo;

        System.out.println("A remuneração do vendedor 1 é R$" +vendedor_1);
        System.out.println("A remuneração do vendedor 2 é R$" +vendedor_2);
        System.out.println("A remuneração do vendedor 3 é R$" +vendedor_3);
        System.out.println("A remuneração do vendedor 4 é R$" +vendedor_4);
    }
}
