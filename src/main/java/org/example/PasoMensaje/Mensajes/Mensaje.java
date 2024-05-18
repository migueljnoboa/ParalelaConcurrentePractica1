package org.example.PasoMensaje.Mensajes;

/**
 * @author me@fredpena.dev
 * @created 06/05/2024  - 15:47
 */
public class Mensaje<T> {
    public Mensaje(T contenido) {
        this.contenido = contenido;
    }

    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}
