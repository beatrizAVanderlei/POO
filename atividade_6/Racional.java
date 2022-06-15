public class Racional {
    private int numerador;
    private int denominador;

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.reduzir();
    }

    private void reduzir() {
        int mdc = mdc(numerador, denominador);
        this.numerador = this.numerador / mdc;
        this.denominador = this.denominador / mdc;
    }

    public int mdc(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int mmc(int a, int b) {
        return a / mdc(a, b) * b;
    }

    public Racional adicao(Racional r) {
        Racional retorno = new Racional(1,1);

        if (this.denominador == r.denominador) {
            retorno.numerador = this.numerador + r.numerador;
            retorno.denominador = this.denominador;
        } else {
            retorno.denominador = mmc(this.denominador, r.denominador);

            this.numerador = this.numerador * (retorno.denominador/this.denominador);
            r.numerador = r.numerador * (retorno.denominador/r.denominador);

            retorno.numerador = this.numerador + r.numerador;
        }
        return retorno;
    }

    public Racional subtracao(Racional r) {
        Racional retorno = new Racional(1,1);
        if (this.denominador == r.denominador) {
            retorno.numerador = this.numerador - r.numerador;
            retorno.denominador = this.denominador;
        } else {
            retorno.denominador = mmc(this.denominador, r.denominador);

            this.numerador = this.numerador * (retorno.denominador/this.denominador);
            r.numerador = r.numerador * (retorno.denominador/r.denominador);

            retorno.numerador = this.numerador - r.numerador;
        }
        return retorno;
    }

    public Racional multiplicacao(Racional r) {
        Racional retorno = new Racional(1,1);
        retorno.numerador = this.numerador * r.numerador;
        retorno.denominador = this.denominador * r.denominador;

        return retorno;
    }

    public Racional divisao(Racional r) {
        Racional retorno = new Racional(1,1);
        retorno.numerador = this.numerador * r.denominador;
        retorno.denominador = r.numerador * this.denominador;

        return retorno;
    }

    public void formaFracao(){
        System.out.println(this.numerador+"/"+this.denominador);
    }

    public void pontoFlutuante(){
        double pontoFlutuante = ((double)this.numerador)/this.denominador;
        System.out.println(pontoFlutuante);
    }
}
