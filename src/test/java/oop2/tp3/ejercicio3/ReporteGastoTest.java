package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReporteGastoTest {
    @Test
    public void test() {
        var g1 = new Gasto();
        var g2 = new Gasto();
        var reporte = new ReporteDeGastos();

        g1.tipoGasto = TipoDeGasto.DESAYUNO;
        g1.monto =1000;
        g2.tipoGasto = TipoDeGasto.CENA;
        g2.monto =2500;
        reporte.agregarGasto(g1);
        reporte.agregarGasto(g2);

        System.out.println(reporte.imprimir(reporte.listaDeGastos()));

    }
}
