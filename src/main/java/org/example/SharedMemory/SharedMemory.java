package org.example.SharedMemory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedMemory {

    private int[][] mat1;
    private int[][] mat2;
    private int size;
    ExecutorService executor;

    public SharedMemory(int threads, int[][] mat1, int[][] mat2, int size) {
        this.mat1 = mat1;
        this.mat2 = mat2;
        this.size = size;
        executor = Executors.newFixedThreadPool(threads);
    }

    public long multiplyMatrix(){

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
                    result[iCal][jCal] = calculoSpecifico(iCal, jCal);
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

        // Retornando tiempo
        return fin - inicio;
    }

    // Formula para calcular cada espacio de la matriz resultante
    private int calculoSpecifico(int pos1, int pos2){

        int result = 0;

        for (int i = 0 ; i < size ; i++){
            result += mat1[pos1][i] * mat2[i][pos2];
        }

        return result;
    }
}


