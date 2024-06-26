package org.example.NormalImplementation;

import org.example.PasoMensaje.Mensajes.Mensaje;
import org.example.PasoMensaje.Mensajes.ResultMatriz;
import org.example.PasoMensaje.Productor;

public class MatrixMultiNormal {

    private final Productor productor;

    public MatrixMultiNormal(Productor productor) {
        this.productor = productor;
    }

    private int calculoSpecifico(int[][] m1, int[][] m2, int size, int pos1, int pos2){

        int result = 0;

        for (int i = 0 ; i < size ; i++){
            result += m1[pos1][i] * m2[i][pos2];
        }

        return result;
    }

    public void multiplyMatrix(int[][] m1, int[][] m2, int size){

        int[][] result = new int[size][size];

        long inicio = System.nanoTime();

        int i, j;

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                result[i][j] = calculoSpecifico(m1, m2, size, i, j);
            }
        }

        long fin = System.nanoTime();

        ResultMatriz resultMatriz = new ResultMatriz(result, "N", fin - inicio);
        Mensaje<ResultMatriz> mensaje = new Mensaje<>(resultMatriz);
        productor.publicar(mensaje);
    }


}
