package Grupo9.avanceiig9.Clases;
import Grupo9.avanceiig9.Enumeradores.Estado;
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
      
 public static Operacion[] gestionVentas = new Operacion[30];
    public static int contador = 0;
    public static void gestionVentas(){
    gestionVentas[contador++] = new Operacion("15/4/2025", 2, 1, Estado.VENTA);
    gestionVentas[contador++] = new Operacion("15/4/2025", 1, 3, Estado.VENTA);
    gestionVentas[contador++] = new Operacion("15/4/2025", 3, 5, Estado.VENTA);
    gestionVentas[contador++] = new Operacion("15/4/2025", 5, 4, Estado.VENTA);
    gestionVentas[contador++] = new Operacion("15/4/2025", 1, 4, Estado.VENTA);
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
        setIdProducto(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:")));
        
        if(Stock.gestionStock[getIdProducto()-1].getCantidadActual()<=0){
        JOptionPane.showMessageDialog(null, "No hay Stock disponible, por favor reponer stock");
        }
        setFecha(JOptionPane.showInputDialog("Ingrese la fecha de la venta:"));
        setCantidadAfectada(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad vendida:")));
        if(getCantidadAfectada()> Stock.gestionStock[getIdProducto()-1].getCantidadActual()){
            JOptionPane.showMessageDialog(null, "No se puede realizar la venta, STOCK INSUFICIENTE");
            
        }else{

            setEstado(estado.VENTA);

            Operacion op =  new Operacion(getFecha(),getCantidadAfectada(),getIdProducto(),getEstado());
            gestionVentas[contador++] = op;
            Stock.gestionStock[getIdProducto()-1].setCantidadActual(Stock.gestionStock[getIdProducto()-1].getCantidadActual()-getCantidadAfectada());
            JOptionPane.showMessageDialog(null, "Venta Registrada: \n\n" + toString());
        }
    }
        

    public void registrarDevolucion() {
        setFecha(JOptionPane.showInputDialog("Ingrese la fecha de la devolución:"));
        String motivo = JOptionPane.showInputDialog("Ingrese el motivo de la devolución:");
        setIdProducto(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:")));
        setCantidadAfectada(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a devolver:")));

        setEstado(estado.DEVOLUCION);
        
        Operacion op =  new Operacion(getFecha(),getCantidadAfectada(),getIdProducto(),getEstado());
        gestionVentas[contador++] = op;
        Stock.gestionStock[getIdProducto()-1].setCantidadActual(Stock.gestionStock[getIdProducto()-1].getCantidadActual()+getCantidadAfectada());

        JOptionPane.showMessageDialog(null, "Devolucion Registrada: \n\n" + toString()+ "Motivo de Devolucion: \n"+motivo);
        
    }

    public void verHistorialMovimientos() {
        String historial = "=== HISTORIAL DE OPERACIONES ===\n\n";

        for (int i = 0; i < contador; i++) {
            historial += "Operación #" + (i + 1) + "\n";
            historial += gestionVentas[i].toString();
            historial += "------------------------\n";
    }

    JOptionPane.showMessageDialog(null, historial);
    }

    @Override
    public String toString() {
        return "Fecha = " + getFecha() + "\n" + 
                "CantidadAfectada = " + getCantidadAfectada() + "\n" + 
                "Id Producto = " + getIdProducto() + "\n" +
                "Producto = " + Videojuego.gestionVideojuegos[getIdProducto()-1].getTitulo() +"\n" +
                "Estado = " + getEstado() + "\n";
    }

}
