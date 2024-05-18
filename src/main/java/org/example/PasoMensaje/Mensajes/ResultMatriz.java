package org.example.PasoMensaje.Mensajes;

public class ResultMatriz {

    private int[][] matriz;
    private String tipo; // N (Normal), S (Shared), D (Distributed)
    private long time;

    public ResultMatriz(int[][] matriz, String tipo, long time) {
        this.matriz = matriz;
        this.tipo = tipo;
        this.time = time;
    }

    public String crearMensaje(){
        
        String nombre = "";
        if (tipo.equals("D")) {
            nombre = "Distribuida";
        } else if (tipo.equals("S")) {
            nombre = "Compartida ";
        }else{
            nombre = "Normal     ";
        }
        
        return "Tiempo de Corrida " + nombre + " " + time + " nano";
    }
}
