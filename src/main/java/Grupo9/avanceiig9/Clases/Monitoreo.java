package Grupo9.avanceiig9.Clases;

import Grupo9.avanceiig9.Enumeradores.Estado;
import javax.swing.JOptionPane;

/**
 *
 * @author felinava06
 */
public class Monitoreo {
    
//    Atributos
    private int idReporte;
    private String fechaMonitoreo;
    private int juegosVendidos;
    private int juegosDevueltos;
    private double ingresosTotales;
    private double perdidasPorDevolucion;
    
    
//    Constructores
    public Monitoreo() {
        
    }
    
    public Monitoreo(int idReporte, String fechaMonitoreo,
            int juegosVendidos, int juegosDevueltos,
            double ingresosTotales,
            double perdidasPorDevolucion
            ) {
        this.idReporte = idReporte;
        this.fechaMonitoreo = fechaMonitoreo;
        this.juegosVendidos = juegosVendidos;
        this.juegosDevueltos = juegosDevueltos;
        this.ingresosTotales = ingresosTotales;
        this.perdidasPorDevolucion = perdidasPorDevolucion;
    }
    
    //    Getter & Setter

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
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
    if(Operacion.gestionVentas.length == 0){
            JOptionPane.showMessageDialog(null, "No hay datos registrador");
            return;
        }
        
    String info = "Lista de Videojuegos: \n";
    for (int i = 0; i < Operacion.contador; i++) {
        if (Operacion.gestionVentas[i].getEstado() == Estado.VENTA){
        info+= Operacion.gestionVentas[i].toString();
        info+= "\n";
        info+= "--- --- --- ---";
        info+= "\n";}
        }
    JOptionPane.showMessageDialog(null, info);
}
public void reporteDevoluciones() {
    if(Operacion.gestionVentas.length == 0){
            JOptionPane.showMessageDialog(null, "No hay datos registrador");
            return;
        }
        
    String info = "Lista de Videojuegos: \n";
    for (int i = 0; i < Operacion.contador; i++) {
        if (Operacion.gestionVentas[i].getEstado() == Estado.DEVOLUCION){
        info+= Operacion.gestionVentas[i].toString();
        info+= "\n";
        info+= "--- --- --- ---";
        info+= "\n";}
        }
    JOptionPane.showMessageDialog(null, info);
}

public void resumenFinanciero() {
    double ingresos = 0;
    double perdidas = 0;
    int vendidos = 0;
    int devueltos = 0;

    for (int i = 0; i < Operacion.contador; i++) {

        if (Operacion.gestionVentas[i] != null) {

            int id = Operacion.gestionVentas[i].getIdProducto() - 1;
            double precio = Videojuego.gestionVideojuegos[id].getPrecio();
            int cantidad = Operacion.gestionVentas[i].getCantidadAfectada();

            if (Operacion.gestionVentas[i].getEstado() == Estado.VENTA) {
                ingresos += precio * cantidad;
                vendidos += cantidad;
            } 
            else if (Operacion.gestionVentas[i].getEstado() == Estado.DEVOLUCION) {
                perdidas += precio * cantidad;
                devueltos += cantidad;
            }
        }
    }

    double gananciaNeta = ingresos - perdidas;

    String info = "=== RESUMEN FINANCIERO ===\n\n";
    info += "Juegos Vendidos: " + vendidos + "\n";
    info += "Juegos Devueltos: " + devueltos + "\n";
    info += "Ingresos Totales: ₡" + ingresos + "\n";
    info += "Pérdidas por Devolución: ₡" + perdidas + "\n";
    info += "Ganancia Neta: ₡" + gananciaNeta;

    JOptionPane.showMessageDialog(null, info);
    
}

    @Override
    public String toString() {
        return "Id Reporte=" + getIdReporte() + "\n"+
                "Fecha Monitoreo=" + getFechaMonitoreo() + "\n"+ 
                "Juegos Vendidos=" + getJuegosVendidos() + "\n"+ 
                "Juegos Devueltos=" + getJuegosDevueltos() + "\n"+ 
                "Ingresos Totales=" + getIngresosTotales() + "\n"+ 
                "Perdidas Por Devolucion=" + getPerdidasPorDevolucion() + "\n";
    }
}
