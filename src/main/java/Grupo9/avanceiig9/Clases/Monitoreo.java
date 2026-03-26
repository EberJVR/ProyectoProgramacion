package feli.avanceiig9.Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author felinava06
 */
public class Monitoreo {
    
//    Atributos
    private String idReporte;
    private String fechaMonitoreo;
    private int juegosVendidos;
    private int juegosDevueltos;
    private double ingresosTotales;
    private double perdidasPorDevolucion;
    private int alertaStockCritico;
    
    
//    Constructores
    public Monitoreo() {
        
    }
    
    public Monitoreo(String idReporte, String fechaMonitoreo,
            int juegosVendidos, int juegosDevueltos,
            double ingresosTotales,
            double perdidasPorDevolucion,
            int alertaStockCritico) {
        this.idReporte = idReporte;
        this.fechaMonitoreo = fechaMonitoreo;
        this.juegosVendidos = juegosVendidos;
        this.juegosDevueltos = juegosDevueltos;
        this.ingresosTotales = ingresosTotales;
        this.perdidasPorDevolucion = perdidasPorDevolucion;
        this.alertaStockCritico = alertaStockCritico;
    }
    
    //    Getter & Setter

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public String getFechaMonitoreo() {
        return fechaMonitoreo;
    }

    public void setFechaMonitoreo(String fechaMonitoreo) {
        this.fechaMonitoreo = fechaMonitoreo;
    }

    public int getJuegosVendidos() {
        return juegosVendidos;
    }

    public void setJuegosVendidos(int juegosVendidos) {
        this.juegosVendidos = juegosVendidos;
    }

    public int getJuegosDevueltos() {
        return juegosDevueltos;
    }

    public void setJuegosDevueltos(int juegosDevueltos) {
        this.juegosDevueltos = juegosDevueltos;
    }

    public double getIngresosTotales() {
        return ingresosTotales;
    }

    public void setIngresosTotales(double ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public double getPerdidasPorDevolucion() {
        return perdidasPorDevolucion;
    }

    public void setPerdidasPorDevolucion(double perdidasPorDevolucion) {
        this.perdidasPorDevolucion = perdidasPorDevolucion;
    }

    public int getAlertaStockCritico() {
        return alertaStockCritico;
    }

    public void setAlertaStockCritico(int alertaStockCritico) {
        this.alertaStockCritico = alertaStockCritico;
    }
    
//    Metodos
    
public void mostrarMenuMonitoreo(){
    int opcion;

    do {
        opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "=== SUBMENÚ MONITOREO ===\n"
                + "1. Reporte de Ventas\n"
                + "2. Reporte de Devoluciones\n"
                + "3. Resumen Financiero\n"
                + "4. Volver\n"
                + "Seleccione una opción:"
        ));

        switch (opcion) {
            case 1:
                reporteVentas();
                break;
            case 2:
                reporteDevoluciones();
                break;
            case 3:
                resumenFinanciero();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
        }

    } while (opcion != 4);
}
public void reporteVentas() {
    JOptionPane.showMessageDialog(null,
            "=== REPORTE DE VENTAS ===\n"
            + "ID Reporte: " + getIdReporte() + "\n"
            + "Fecha: " + getFechaMonitoreo() + "\n"
            + "Juegos Vendidos: " + getJuegosVendidos() + "\n"
            + "Ingresos Totales: ₡" + getIngresosTotales()
    );
}
public void reporteDevoluciones() {
    JOptionPane.showMessageDialog(null,
            "=== REPORTE DE DEVOLUCIONES ===\n"
            + "Juegos Devueltos: " + getJuegosDevueltos() + "\n"
            + "Pérdidas por Devolución: ₡" + getPerdidasPorDevolucion()
    );
}

public void resumenFinanciero() {
    double gananciaNeta = getIngresosTotales() - getPerdidasPorDevolucion();

    JOptionPane.showMessageDialog(null,
            "=== RESUMEN FINANCIERO ===\n"
            + "Ingresos Totales: ₡" + getIngresosTotales() + "\n"
            + "Pérdidas: ₡" + getPerdidasPorDevolucion() + "\n"
            + "Ganancia Neta: ₡" + gananciaNeta + "\n"
            + "Alertas de Stock Crítico: " + getAlertaStockCritico()
    );
}
}
