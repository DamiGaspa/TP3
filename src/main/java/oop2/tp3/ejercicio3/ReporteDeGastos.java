package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum TipoDeGasto {
    CENA, DESAYUNO, ALQUILER_AUTO
}

class Gasto {
    TipoDeGasto tipoGasto;
    int monto;
}

public class ReporteDeGastos {
    private List<Gasto> gastos;

    public ReporteDeGastos() {
        this.gastos = new ArrayList<Gasto>();
    }

    public String imprimir(List<Gasto> gastos) {
        int total = 0;
        int gastosDeComida = 0;

        for (Gasto gasto : gastos) {
            if (EsCena(gasto) || EsDesayuno(gasto)) {
                gastosDeComida += gasto.monto;
            }

            String tipoGasto = esGastoDe(gasto);

            String marcaExcesoComidas = excesoComidas(gasto, 5000, 1000);

            total += gasto.monto;
        }
        return "Expenses " + LocalDate.now() + "\nGasto total: " + total;
    }

    private static String excesoComidas(Gasto gasto, int montoCena, int montoDesayuno) {
        return gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > montoCena
                || gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > montoDesayuno ? "X" : " ";
    }

    private static String esGastoDe(Gasto gasto) {
        String nombreGasto = "";
        switch (gasto.tipoGasto) {
            case CENA:
                nombreGasto = "Cena";
                break;
            case DESAYUNO:
                nombreGasto = "Desayuno";
                break;
            case ALQUILER_AUTO:
                nombreGasto = "Alquiler de Autos";
                break;
        }
        return nombreGasto;
    }

    private static boolean EsDesayuno(Gasto gasto) {
        return gasto.tipoGasto == TipoDeGasto.DESAYUNO;
    }

    private static boolean EsCena(Gasto gasto) {
        return gasto.tipoGasto == TipoDeGasto.CENA;
    }

    public void agregarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public List<Gasto> listaDeGastos() {
        return gastos;
    }
}
