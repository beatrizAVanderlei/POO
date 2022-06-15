package retangulo;
public class Retangulo {
        private double altura;
        private double largura;

        public double getAltura(){
            return altura;
        }
        public double getLargura(){
            return largura;
        }
        public void setAltura(double altura){
            if ((altura > 0.0) && (altura < 20.0))
                this.altura = altura;
        }
        public void setLargura(double largura){
            if ((largura > 0.0) && (largura < 20.0))
                this.largura = largura;
        }

        public double perimetro (){
            return (largura*2)+(altura*2);
        }
        public double area (){
            return largura*altura;
        }
}

