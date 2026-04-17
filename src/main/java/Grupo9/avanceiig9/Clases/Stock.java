package Grupo9.avanceiig9.Clases;

import static Grupo9.avanceiig9.Clases.Operacion.contador;
import static Grupo9.avanceiig9.Clases.Operacion.gestionVentas;
import Grupo9.avanceiig9.Enumeradores.Estado;
import javax.swing.JOptionPane;

public class Stock {
    
    private int idProducto;
    private int cantidadActual;
    private int stockMinimo;

    public Stock() {
    }

    public Stock(int idProducto, int cantidadActual, int stockMinimo) {
        this.idProducto = idProducto;
        this.cantidadActual = cantidadActual;
        this.stockMinimo = stockMinimo;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

     public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
     public int getIdProducto() {
        return idProducto;
    }
     
    public static Stock[] gestionStock = new Stock[10]; 
    public static int contadorStock = 0;
   
    public static void gestionStock(){
        gestionStock[contadorStock++] = new Stock(1, 10, 3);
        gestionStock[contadorStock++] = new Stock(2, 2, 3);
        gestionStock[contadorStock++] = new Stock(3, 10, 3);
        gestionStock[contadorStock++] = new Stock(4, 10, 3);
        gestionStock[contadorStock++] = new Stock(5, 10, 3);
}  
    
    
    public void mostrarmenuStock() {
        int opcion = 0;
        do {
            String lectura = JOptionPane.showInputDialog(
                    "=== CONTROL DE STOCK ===\n"
                    + "1. Actualizar Existencias de un Juego\n"
                    + "2. Ajustar Stock Mínimo de un Juego\n"
                    + "3. Ver Alertas de Inventario\n"
                    + "4. Volver\n"
                    + "Seleccione una opción:"
            );

            if (lectura == null) {
                opcion = 4;
            } else {
                opcion = Integer.parseInt(lectura);
            }

            switch (opcion) {
                case 1:
                    actualizarExistencias();
                    break;
                case 2:
                    ajustarstockMinimo();
                    break;
                case 3:
                    alertasInventario();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 4);
    }

    public void actualizarExistencias() {
    int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("ID del videojuego:"));
    boolean encontrado = false;

    for (int i = 0; i < contadorStock; i++) {

        if (gestionStock[i] != null &&
            gestionStock[i].getIdProducto() == idBuscar) {

            int nuevaCantidad = Integer.parseInt(
                JOptionPane.showInputDialog("Nueva cantidad:")
            );

            gestionStock[i].setCantidadActual(nuevaCantidad);

            JOptionPane.showMessageDialog(null, "Actualizado.");
            encontrado = true;
            break;
        }}
    
        if (!encontrado) {
            
        int cantidad = Integer.parseInt(
            JOptionPane.showInputDialog("Juego no encontrado pero creado.... \n Agregandolo al Stock... \n Cantidad inicial:")
        );

        Stock nuevo = new Stock(idBuscar, cantidad, 2);
        gestionStock[contadorStock++] = nuevo;

        JOptionPane.showMessageDialog(null, "Stock creado.");
    }
    }

    
    

    public void ajustarstockMinimo() {
    int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
    boolean encontrado = false;

    for (int i = 0; i < contadorStock; i++) {

        if (gestionStock[i] != null &&
            gestionStock[i].getIdProducto() == idBuscar) {

            int nuevoMin = Integer.parseInt(
                JOptionPane.showInputDialog("Nuevo stock mínimo:")
            );

            gestionStock[i].setStockMinimo(nuevoMin);

            JOptionPane.showMessageDialog(null, "Actualizado.");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Stock no encontrado.");
    }
}

    public void alertasInventario() {
    int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
    boolean encontrado = false;

    for (int i = 0; i < contadorStock; i++) {

        if (gestionStock[i] != null &&
            gestionStock[i].getIdProducto() == idBuscar) {

            String estado;

            if (gestionStock[i].getCantidadActual() <= gestionStock[i].getStockMinimo()) {
                estado = "CRÍTICO: Reponer";
            } else {
                estado = "Suficiente";
            }

            String nombre = "";

            for (int j = 0; j < Videojuego.contador; j++) {
                if (Videojuego.gestionVideojuegos[j].getIdVideojuego() == idBuscar) {
                    nombre = Videojuego.gestionVideojuegos[j].getTitulo();
                    break;
                }
            }

            String info = "=== ALERTA ===\n";
            info += "Juego: " + nombre + "\n";
            info += "Cantidad Actual: " + gestionStock[i].getCantidadActual() + "\n";
            info += "Stock Mínimo: " + gestionStock[i].getStockMinimo() + "\n";
            info += "Estado: " + estado;

            JOptionPane.showMessageDialog(null, info);

            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Stock no encontrado.");
    }
}

   
}