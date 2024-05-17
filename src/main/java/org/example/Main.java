package org.example;

import org.example.NormalImplementation.MatrixMultiNormal;
import org.example.SharedMemory.SharedMemory;

public class Main {

    public static void main(String[] args) {
        int size = 3;
        int mat1[][] = new int[][] { { 1, 1, 1}, { 2, 2, 2}, { 3, 3, 3}};
        int mat2[][] = new int[][] { { 1, 1, 1}, { 2, 2, 2}, { 3, 3, 3}};

        MatrixMultiNormal matrixMultiNormal = new MatrixMultiNormal();
        System.out.println("Tiempo de Corrida Normal: " + matrixMultiNormal.multiplyMatrix(mat1, mat2, size) + " nano");

        System.out.println();

        SharedMemory sharedMemory = new SharedMemory(2, mat1, mat2, size);
        System.out.println("Tiempo de Corrida Compartida: " + sharedMemory.multiplyMatrix() + " nano");

    }
}