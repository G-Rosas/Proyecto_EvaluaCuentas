package services;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class CuentasService {

    private static final String RUTA_ARCHIVOS = "D:/CIBERTEC/Ciclo_7/APPS WEB 2/Examen1/grv-examen1-2/txt/";
    public void procesarArchivoCuentas(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray cuentasArray = new JSONArray(content);
            for (int i = 0; i < cuentasArray.length(); i++) {
                JSONObject cuenta = cuentasArray.getJSONObject(i);
                boolean estado = cuenta.getBoolean("estado");
                double saldo = cuenta.getDouble("saldo");
                String banco = cuenta.getString("banco");
                int nroCuenta = cuenta.getInt("nro_cuenta");
                if (estado) {
                    String resultado;
                    if (saldo > 5000.00) {
                        resultado = String.format(Locale.US,"Banco de origen: %s\nLa cuenta con el nro de cuenta: %d tiene un saldo de %.4f.\n" +
                                "Usted es apto a participar en el concurso de la SBS por 10000.00 soles.\nSuerte!\n", banco, nroCuenta, saldo);
                    } else {
                        resultado = String.format(Locale.US,"Banco de origen: %s\nLa cuenta con el nro de cuenta: %d no tiene un saldo superior a 5000.00.\n" +
                                "Lamentablemente no podrá acceder al concurso de la SBS por 10000.00 soles.\nGracias\n", banco, nroCuenta);
                    }
                    crearArchivoTexto(nroCuenta, resultado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void crearArchivoTexto(int nroCuenta, String contenido) {
        String fileName = "cuenta_" + nroCuenta + ".txt";
        String filePath = RUTA_ARCHIVOS + fileName;
        try (FileWriter fileWriter = new FileWriter(new File(filePath))) {
            fileWriter.write(contenido);
            System.out.println("Archivo creado: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
