package org.example.PasoMensaje;

import com.sun.net.httpserver.Authenticator;
import org.example.PasoMensaje.Mensajes.Mensaje;
import org.example.PasoMensaje.Mensajes.ResultMatriz;

import java.util.Random;

/**
 * @author me@fredpena.dev
 * @created 09/05/2024  - 08:45
 */
public class ConsumidorInfo extends Consumidor {

    @Override
    public void procesarMensaje(Mensaje mensaje) {
        ResultMatriz resultMatriz = (ResultMatriz) mensaje.getContenido();
        System.out.println(resultMatriz.crearMensaje());
    }
}
