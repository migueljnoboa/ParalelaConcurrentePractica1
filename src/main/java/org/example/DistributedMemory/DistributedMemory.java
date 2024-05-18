package org.example.DistributedMemory;

import org.example.PasoMensaje.Mensajes.Mensaje;
import org.example.PasoMensaje.Mensajes.ResultMatriz;
import org.example.PasoMensaje.Productor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DistributedMemory {

    ExecutorService executor;
    Productor productor;

    public DistributedMemory(int threads, Productor productor) {
        this.executor = Executors.newFixedThreadPool(threads);
        this.productor = productor;
    }

    public void multiplyMatrix(int[][] mat1, int[][] mat2, int size){

        // Creando la matriz resultante
        int[][] result = new int[size][size];

        long inicio = System.nanoTime();

        // Empezando el algoritmo, un for loop para para espacio de la matriz
        int i, j;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {

                // creando agregando los calculos al thread.
                int iCal = i;
                int jCal = j;
                Runnable calculo = () -> {
                    result[iCal][jCal] = calculoSpecifico(mat1, mat2, size, iCal, jCal);
                };

                // ejecutando el calculo
                executor.execute(calculo);
            }
        }

        // Diciendole a todos que terminen
        executor.shutdown();

        // Esperando que termine
        try{
            executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var fin = System.nanoTime();

        ResultMatriz resultMatriz = new ResultMatriz(result, "D", fin - inicio);
        Mensaje<ResultMatriz> mensaje = new Mensaje<>(resultMatriz);
        productor.publicar(mensaje);

    }


    private int calculoSpecifico(int[][] mat1, int[][] mat2, int size, int pos1, int pos2){

        int result = 0;

        for (int i = 0 ; i < size ; i++){
            result += mat1[pos1][i] * mat2[i][pos2];
        }

        return result;
    }
}
