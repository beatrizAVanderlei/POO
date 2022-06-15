public class Teste{
    public static void main (String[] args) {
        Conta conta1 = new Conta("1335-9", 1000.00);

        Conta conta2 = new Conta("7886-3", 0);

        for (int i = 0; i < 10; i++) {
            conta1.transferencia(conta2, 100);
        }
        for (int i = 0; i < 10; i++) {
            conta2.transferencia(conta1, 10);
        }

        System.out.println("O saldo da conta "+conta1.numero+" é "+conta1.consultarSaldo());
        System.out.println("O saldo da conta "+conta2.numero+" é "+conta2.consultarSaldo());
        System.out.println("O número de transferências realizadas da conta "+conta1.numero+" foi "+conta1.contador.consultar());
        System.out.println("O número de transferências realizadas da conta "+conta2.numero+" foi "+conta2.contador.consultar());
    }
}

