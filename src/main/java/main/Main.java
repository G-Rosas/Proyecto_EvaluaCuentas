package main;

import controllers.CuentasController;

public class Main {
    public static void main(String[] args) {
        CuentasController controller = new CuentasController();
        String filePath = "D:/CIBERTEC/Ciclo_7/APPS WEB 2/Examen1/grv-examen1-2/json/cuentas.json";


        controller.procesarCuentas(filePath);
    }
}
