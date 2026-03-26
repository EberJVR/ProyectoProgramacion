package feli.avanceiig9.Clases;
import feli.avanceiig9.Enumeradores.Estado;
import javax.swing.JOptionPane;

/**
 *
 * @author felinava06
 */
public class Operacion {
    
//    Atributos
    private String fecha;
    private int cantidadAfectada;
    private int idProducto;
    private Estado estado;
    

//    Constructores

    public Operacion() {
        
    }
    
    public Operacion(String fecha, int cantidadAfectada, int idProducto, Estado estado) {
        this.fecha = fecha;
        this.cantidadAfectada = cantidadAfectada;
        this.idProducto = idProducto;
        this.estado = estado;
    }
      
    
//    Metodos
    public void menuOperaciones() {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== REGISTRO DE OPERACIONES ===\n"
                    + "1. Registrar Venta\n"
                    + "2. Registrar Devolución\n"
                    + "3. Ver Historial de Movimientos\n"
                    + "4. Volver\n"
                    + "Seleccione una opción:"
            ));

            switch (opcion) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    registrarDevolucion();
                    break;
                case 3:
                    verHistorialMovimientos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 4);
    }

    public void registrarVenta() {
        JOptionPane.showInputDialog("Ingrese la fecha de la venta:");
        JOptionPane.showInputDialog("Ingrese el ID del producto:");
        JOptionPane.showInputDialog("Ingrese la cantidad vendida:");
        
        JOptionPane.showMessageDialog(null, 
                "=== Venta Registrada ===\n"
                + "Producto ID: " + getIdProducto() + "\n"
                + "Cantidad: " + getCantidadAfectada() + "\n"
                + "Estado: " + getEstado());
    }

    public void registrarDevolucion() {
        JOptionPane.showInputDialog("Ingrese el motivo de la devolución:");
        JOptionPane.showInputDialog("Ingrese la cantidad a devolver:");
        JOptionPane.showMessageDialog(null, 
                "=== Devolución Registrada ===\n"
                + "Fecha: " + getFecha() + "\n"
                + "Cantidad devuelta: " + getCantidadAfectada());
    }

    public void verHistorialMovimientos() {
            JOptionPane.showMessageDialog(null,
                "=== HISTORIAL DE MOVIMIENTOS ===\n"
                + "Última operación: " + getFecha() + "\n"
                + "Cantidad afectada: " + getCantidadAfectada() + "\n"
                + "ID Producto: " + getIdProducto());
    }

//    Getter & Setter

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadAfectada() {
        return cantidadAfectada;
    }

    public void setCantidadAfectada(int cantidadAfectada) {
        this.cantidadAfectada = cantidadAfectada;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
