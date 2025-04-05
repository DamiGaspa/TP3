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

            String marcaExcesoComidas = gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > 5000
                    || gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > 1000 ? "X" : " ";

            total += gasto.monto;
        }
        return "Expenses " + LocalDate.now() + "\nGasto total: " + total;
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
