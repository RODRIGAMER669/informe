package com.psp.primera.evaluacion.ejercicio.informe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final static String[] COMANDOS = {"ps", "df", "free"};
    final static String FICHERO = "InformeSistema";

    public static void main(String[] args) {

        StringBuilder informe = new StringBuilder();

        for (String comando : COMANDOS) {
            informe.append("## Comando: ").append(comando).append("\n\n");
            informe.append(ejecutarComando(comando)).append("\n\n");
        }

        GuardarInforme guardador = new GuardarMarkdown();
        guardador.guardar(informe.toString(), FICHERO);
    }

    private static String ejecutarComando(String comando) {
        StringBuilder resultado = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(comando);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                resultado.append(linea).append("\n");
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.getMessage();
        }
        return resultado.toString();
    }
}
