package org.example.PasoMensaje;


import org.example.PasoMensaje.Mensajes.Mensaje;

/**
 * @author me@fredpena.dev
 * @created 06/05/2024  - 15:49
 */
public class Productor {

    private Canal canal;

    public Productor(Canal canal) {
        this.canal = canal;
    }

    public void publicar(Mensaje mensaje) {
        canal.pasarMensaje(mensaje);
    }

}
