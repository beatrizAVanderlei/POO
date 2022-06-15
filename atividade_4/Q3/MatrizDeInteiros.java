public class MatrizDeInteiros {
    public static boolean eIgual(int[][] matrizA, int[][] matrizB){
        boolean retorno = true;

        if ((matrizA.length == matrizB.length) && (matrizA[0].length == matrizB[0].length)) {
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA.length; j++) {
                    if (matrizA[i][j] != matrizB[i][j]) {
                        retorno = false;
                    }
                }
            }

        }
        else{
            retorno = false;
        }
        return retorno;
    }
    public static boolean éQuadrada(int[][] matriz){
        boolean retorno = true;
        if (matriz.length == matriz[0].length){
            retorno = true;
        }
        else{
            retorno = false;
        }
        return retorno;
    }
    public static void main(String[] args) {
        int[][] matriz1 = new int[][]{{1,3},{4,6}};
        int[][] matriz2 = new int[][]{{1,2,3},{4,5,6}};

        if (eIgual(matriz1, matriz2) == true){
            System.out.println("As matrizes são iguais");
        }
        else{
            System.out.println("As matrizes não são iguais");
        }
        if (éQuadrada(matriz1) == true){
            System.out.println("A matriz selecionada é quadrada");
        }
        else{
            System.out.println("A matriz selecionada não é quadrada");
        }
    }
}
