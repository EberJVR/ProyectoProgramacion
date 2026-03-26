package feli.avanceiig9.Clases;
import feli.avanceiig9.Enumeradores.Estado;

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
    
//    Submenú ----> Registro de Operaciones
//      Las opciones que debe de tener son 
//      Registrar Venta
//      Registrar Devolución
//      Ver Historial de Movimientos
//      Volver
      

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
