package org.example.SharedMemory;

import org.example.PasoMensaje.Mensajes.Mensaje;
import org.example.PasoMensaje.Mensajes.ResultMatriz;
import org.example.PasoMensaje.Productor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedMemory {

    ExecutorService executor;
    Productor productor;

    public SharedMemory(int threads, Productor productor) {
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

                    int rst = 0;
                    for (int k = 0 ; k < size ; k++){
                        rst += mat1[iCal][k] * mat2[k][jCal];
                    }
                    result[iCal][jCal] = rst;
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
        ResultMatriz resultMatriz = new ResultMatriz(result, "S", fin - inicio);
        Mensaje<ResultMatriz> mensaje = new Mensaje<>(resultMatriz);
        productor.publicar(mensaje);
    }
}


