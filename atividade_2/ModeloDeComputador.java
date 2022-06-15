class ModeloDeComputador {
    int inicial = 800; // é o valor de toda placa mãe
    String processador, memoria, disco_rigido, monitor;

    public double preco_computador(){
        double total = inicial;

        if (processador.equals("600Mhz")){
            total += 700;
        }
        if (processador.equals("800Mhz")){
            total += 830;
        }
        if (processador.equals("933Mhz")){
            total += 910;
        }
        if (memoria.equals("128 Mb")){
            total += 350;
        }
        if (memoria.equals("256 Mb")){
            total += 350*2;
        }
        if (memoria.equals("384 Mb")){
            total += 350*3;
        }
        if (memoria.equals("512 Mb")){
            total += 350*4;
        }
        if (disco_rigido.equals("20 Gb")){
            total += 300;
        }
        if (disco_rigido.equals("40 Gb")){
            total += 420;
        }
        if (disco_rigido.equals("60 Gb")){
            total += 500;
        }
        if (monitor.equals("15 polegadas")){
            total += 320;
        }
        if (monitor.equals("17 polegadas")){
            total += 520;
        }
        return total;
    }
}
