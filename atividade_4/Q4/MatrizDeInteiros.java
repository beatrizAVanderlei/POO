import java.util.ArrayList;
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
    public static boolean eQuadrada(int[][] matriz){
        boolean retorno = true;
        if (matriz.length == matriz[0].length){
            retorno = true;
        }
        else{
            retorno = false;
        }
        return retorno;
    }
    public static boolean eQuadradoMagico(int[][] matriz){
        ArrayList numeros = new ArrayList();
        boolean retorno = true;
        int somaMatriz = 0;
        int somaTeste = 0;

        if (matriz.length == matriz[0].length){
            for (int i = 0; i < matriz.length; i++){
                for (int j = 0; j < matriz.length; j++){
                    if (numeros.contains(matriz[i][j])){
                        return false;
                    }
                    numeros.add(matriz[i][j]);
                }
            }
            for(int i = 0; i < matriz.length; i++){
                 somaMatriz += matriz[i][i];
            }
            for(int i = 0; i < matriz.length; i++){
                somaTeste = 0;
                for(int j = 0; j < matriz.length; j++){
                    somaTeste += matriz[i][j];
                }
                if(somaTeste != somaMatriz){
                    return false;
                }
            }
            for(int i = 0; i < matriz.length; i++){
                somaTeste = 0;
                for(int j = 0; j < matriz.length; j++){
                    somaTeste += matriz[j][i];
                }
                if(somaTeste != somaMatriz){
                    return false;
                }
            }
        }
        else{
            retorno = false;
        }

        return retorno;
    }
    public static void main(String[] args) {
        int[][] matriz1 = new int[][]{{1,2,3},{4,5,6}};
        int[][] matriz2 = new int[][]{{1,2,3},{4,5,6}};

        if (eIgual(matriz1, matriz2) == true){
            System.out.println("As matrizes são iguais");
        }
        else{
            System.out.println("As matrizes não são iguais");
        }
        if (eQuadrada(matriz1) == true){
            System.out.println("A matriz selecionada é quadrada");
        }
        else{
            System.out.println("A matriz selecionada não é quadrada");
        }
        if(eQuadradoMagico(matriz1) == true){
            System.out.println("A matriz selecinada é um quadrado mágico");
        }
        else{
            System.out.println("A matriz selecionada não é um quadrado mágico");
        }
    }
}
