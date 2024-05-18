package org.example.PasoMensaje;

import org.example.PasoMensaje.Mensajes.Mensaje;

/**
 * @author me@fredpena.dev
 * @created 06/05/2024  - 15:48
 */
public abstract class Consumidor {

    public abstract void procesarMensaje(Mensaje mensaje);

}
