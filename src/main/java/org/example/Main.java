package org.example;

import org.example.DistributedMemory.DistributedMemory;
import org.example.PasoMensaje.Canal;
import org.example.NormalImplementation.MatrixMultiNormal;
import org.example.PasoMensaje.ConsumidorInfo;
import org.example.PasoMensaje.Mensajes.Mensaje;
import org.example.PasoMensaje.Productor;
import org.example.SharedMemory.SharedMemory;

public class Main {

    public static void main(String[] args) {

        Canal canal = new Canal();
        canal.registrarConsumidor(new ConsumidorInfo());
        Productor productor = new Productor(canal);

        int size = 2;
        int[][] mat1 = new int[][] { { 1, 1}, { 2, 2}};
        int[][] mat2 = new int[][] { { 1, 1}, { 2, 2}};

        System.out.println();
        System.out.println("Probando Tiempos de corrida con matriz de size 2x2");

        MatrixMultiNormal matrixMultiNormal = new MatrixMultiNormal(productor);
        matrixMultiNormal.multiplyMatrix(mat1, mat2, size);

        SharedMemory sharedMemory = new SharedMemory(2, productor);
        sharedMemory.multiplyMatrix(mat1, mat2, size);

        DistributedMemory distributedMemory = new DistributedMemory(2, productor);
        distributedMemory.multiplyMatrix(mat1, mat2, size);



        size = 3;
        mat1 = new int[][] { { 1, 1, 1}, { 2, 2, 2}, { 3, 3, 3}};
        mat2 = new int[][] { { 1, 1, 1}, { 2, 2, 2}, { 3, 3, 3}};

        System.out.println();
        System.out.println("Probando Tiempos de corrida con matriz de size 3x3");

        matrixMultiNormal = new MatrixMultiNormal(productor);
        matrixMultiNormal.multiplyMatrix(mat1, mat2, size);

        sharedMemory = new SharedMemory(2, productor);
        sharedMemory.multiplyMatrix(mat1, mat2, size);

        distributedMemory = new DistributedMemory(2, productor);
        distributedMemory.multiplyMatrix(mat1, mat2, size);

        size = 4;
        mat1 = new int[][] { { 1, 1, 1, 1}, { 2, 2, 2, 2}, { 3, 3, 3, 3}, { 4, 4, 4, 4}};
        mat2 = new int[][] { { 1, 1, 1, 1}, { 2, 2, 2, 2}, { 3, 3, 3, 3}, { 4, 4, 4, 4}};

        System.out.println();
        System.out.println("Probando Tiempos de corrida con matriz de size 4x4");

        matrixMultiNormal = new MatrixMultiNormal(productor);
        matrixMultiNormal.multiplyMatrix(mat1, mat2, size);

        sharedMemory = new SharedMemory(2, productor);
        sharedMemory.multiplyMatrix(mat1, mat2, size);

        distributedMemory = new DistributedMemory(2, productor);
        distributedMemory.multiplyMatrix(mat1, mat2, size);

    }
}