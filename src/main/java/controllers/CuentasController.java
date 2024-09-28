package controllers;

import services.CuentasService;

public class CuentasController {
    private final CuentasService cuentasService;

    public CuentasController() {
        this.cuentasService = new CuentasService();
    }
    public void procesarCuentas(String filePath) {
        cuentasService.procesarArchivoCuentas(filePath);
    }
}