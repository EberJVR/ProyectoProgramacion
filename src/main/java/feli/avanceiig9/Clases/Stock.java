package feli.avanceiig9.Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author felinava06
 */
public class Stock {
    
//    Atributos
     private int cantidadActual;
     private int stockMinimo;
     
//    Constructores
     
     public Stock() {
        
    }
     
    public Stock(int cantidadActual, int stockMinimo) {
        this.cantidadActual = cantidadActual;
        this.stockMinimo = stockMinimo;
    }


//    Metodos
    public void mostrarmenuStock() {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== CONTROL DE STOCK ===\n"
                    + "1. Actualizar Existencias\n"
                    + "2. Ajustar Stock Mínimo\n"
                    + "3. Ver Alertas de Inventario\n"
                    + "4. Volver\n"
                    + "Seleccione una opción:"
            ));

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
        JOptionPane.showInputDialog("Ingrese la nueva cantidad actual:");
        JOptionPane.showMessageDialog(null, "Existencias actualizadas. Cantidad actual: " + getCantidadActual());
    }

    public void ajustarstockMinimo() {
        JOptionPane.showInputDialog("Ingrese el nuevo límite de stock mínimo:");
        JOptionPane.showMessageDialog(null, "Stock mínimo ajustado a: " + getStockMinimo());
    }

    public void alertasInventario() {
        JOptionPane.showMessageDialog(null,
                "=== ALERTAS DE INVENTARIO ===\n"
                + "Cantidad Actual: " + getCantidadActual() + "\n"
                + "Stock Mínimo: " + getStockMinimo() + "\n"
                + "Estado: Sin alertas");
    }
    
//   Getter & Setter

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
    

}
