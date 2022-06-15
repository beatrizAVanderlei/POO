import java.util.Scanner;
public class Teste2 {
    public static void main(String[] args) {
        Conta conta1 = new Conta("1335-9", 500.00);
        Conta conta2 = new Conta("7886-3", 500.00);

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor da transferência: ");
        double valorTransferido = sc.nextDouble();
        System.out.println("Digite o número da origem: ");
        String origem = sc.next();
        System.out.println("Digite o número do destino: ");
        String destino = sc.next();

        if ((origem.equals(conta1.numero)) && (destino.equals(conta2.numero)) ){
            conta1.transferencia(conta2, valorTransferido);
        }
        else if ((origem.equals(conta2.numero)) && (destino.equals(conta1.numero))){
            conta2.transferencia(conta1, valorTransferido);
        }
        else{
            System.out.println("Contas não registradas");
        }

        System.out.println("O saldo da conta "+conta1.numero+" é "+conta1.consultarSaldo());
        System.out.println("O saldo da conta "+conta2.numero+" é "+conta2.consultarSaldo());
        System.out.println("O número de transferências realizadas da conta "+conta1.numero+" foi "+conta1.contador.consultar());
        System.out.println("O número de transferências realizadas da conta "+conta2.numero+" foi "+conta2.contador.consultar());
    }
}
