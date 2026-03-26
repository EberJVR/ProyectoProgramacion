package feli.avanceiig9.Clases;

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
    
//    Submenú ---> Control de Stock
//      Las opciones que debe de tener son 
//      Actualizar Existencias
//      Ajustar Stock Mínimo
//      Ver Alertas de Inventario
//      Volver
    
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
