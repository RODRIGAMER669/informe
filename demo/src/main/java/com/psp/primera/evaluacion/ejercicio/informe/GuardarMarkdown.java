package com.psp.primera.evaluacion.ejercicio.informe;

import java.io.FileWriter;
import java.io.IOException;

public class GuardarMarkdown implements GuardarInforme {

    @Override
    public void guardar(String contenido, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo + ".md")) {
            writer.write(contenido);
            System.out.println("Informe guardado en " + nombreArchivo + ".md");
        } catch (IOException e) {
            System.err.println("Error al guardar el informe: " + e.getMessage());
        }
    }
}
