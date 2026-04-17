package Grupo9.avanceiig9.Clases;
import Grupo9.avanceiig9.Enumeradores.Estado;
import javax.swing.JOptionPane;

public class Videojuego {

    private int idVideojuego;
    private String titulo;
    private String plataforma;
    private float precio;

    public static Videojuego[] gestionVideojuegos = new Videojuego[10];
    public static int contador = 0;

    public static void gestionVideojuegos() {
        gestionVideojuegos[contador++] = new Videojuego(1, "Call Of Duty", "Ps3", 24000);
        gestionVideojuegos[contador++] = new Videojuego(2, "GTA V", "PC", 30000);
        gestionVideojuegos[contador++] = new Videojuego(3, "Cuphead", "Ps4", 20000);
        gestionVideojuegos[contador++] = new Videojuego(4, "Mortal Kombat", "Xbox", 28000);
        gestionVideojuegos[contador++] = new Videojuego(5, "Mario Galaxy", "Nintendo switch", 18000);
    }

    public Videojuego() {
    }

    public Videojuego(int idVideojuego, String titulo, String plataforma, float precio) {
        this.idVideojuego = idVideojuego;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }
    
    public int getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public  void menuVideojuegos() {
        int subOpcion = 0;
        do {
            String lectura = JOptionPane.showInputDialog(
                    "=== GESTIÓN DE VIDEOJUEGOS ===\n"
                    + "1. Agregar Videojuego\n"
                    + "2. Consultar Datos\n"
                    + "3. Modificar Precio\n"
                    + "4. Eliminar Juego\n"
                    + "5. Volver\n"
                    + "Seleccione una opción:"
            );

            if (lectura == null) {
                subOpcion = 5;
            } else {
                subOpcion = Integer.parseInt(lectura);
            }

            switch (subOpcion) {
                case 1:
                    agregarVideojuego();
                    break;
                case 2:
                    consultarDatos();
                    break;
                case 3:
                    modificarPrecio();
                    break;
                case 4:
                    eliminarJuego();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (subOpcion != 5);
    }
    
    public static Videojuego buscarVideojuegoPorId(int id) {
    for (int i = 0; i < Videojuego.contador; i++) {
        if (Videojuego.gestionVideojuegos[i] != null &&
            Videojuego.gestionVideojuegos[i].getIdVideojuego() == id) {
            return Videojuego.gestionVideojuegos[i];
        }
    }
    return null;
}

    public void agregarVideojuego() {
        if (contador < gestionVideojuegos.length) {
            
            setIdVideojuego(contador+1);
            setTitulo(JOptionPane.showInputDialog("Título:"));
            setPlataforma(JOptionPane.showInputDialog("Plataforma:"));
            setPrecio(Float.parseFloat(JOptionPane.showInputDialog("Precio:")));
            
            
            
            Videojuego nuevo = new Videojuego(getIdVideojuego(), getTitulo(), getPlataforma(), getPrecio());
            gestionVideojuegos[contador++] = nuevo;
            
            JOptionPane.showMessageDialog(null, "Registrado con éxito."+"\n\n"+toString());
        } else {
            JOptionPane.showMessageDialog(null, "Arreglo lleno.");
        }
    }

    public void consultarDatos() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros.");
            return;
        }
        
        String info = "Lista de Videojuegos: \n";
        for (int i = 0; i < contador; i++) {
            
            info+= gestionVideojuegos[i].toString();
            info+= "\n";
            info+= "--- --- --- ---";
            info+= "\n";}
        
    JOptionPane.showMessageDialog(null, info);
    
    }

    public void modificarPrecio() {
        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("ID a modificar:"));
        boolean encontrado = false;

        for (int i = 0; i < contador; i++) {
            if (gestionVideojuegos[i].getIdVideojuego() == idBuscar) {
                gestionVideojuegos[i].setPrecio((Float.parseFloat(JOptionPane.showInputDialog("Nuevo precio:"))));
                JOptionPane.showMessageDialog(null, "Actualizado.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
        }
    }
    
    public void eliminarJuego() {
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("ID a eliminar:"));
        int indice = -1;
        
//        Validacion para Eliminar el Juego
                
        for (int i = 0; i < contador; i++) {
            if (gestionVideojuegos[i].getIdVideojuego() == idEliminar) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            for (int i = indice; i < contador - 1; i++) {
                gestionVideojuegos[i] = gestionVideojuegos[i + 1]; 
            }
            gestionVideojuegos[contador - 1] = null;
            contador--;
            for(int j = 0; j < contador;j++){
            gestionVideojuegos[j].setIdVideojuego(j+1);
            }
            
//            Validacion para eliminar el stock con el mismo codigo si esta creado

            for (int i = 0; i < Stock.contadorStock; i++) {

            if (Stock.gestionStock[i] != null) {

                int idActual = Stock.gestionStock[i].getIdProducto();

                if (idActual == idEliminar) {
                    // eliminar este stock
                    for (int j = i; j < Stock.contadorStock - 1; j++) {
                        Stock.gestionStock[j] = Stock.gestionStock[j + 1];
                    }
                    Stock.gestionStock[Stock.contadorStock - 1] = null;
                    Stock.contadorStock--;
                    i--; 
                } 
                else if (idActual > idEliminar) {
                    // ajustar ID
                    Stock.gestionStock[i].setIdProducto(idActual - 1);
                }
            }

        }
            JOptionPane.showMessageDialog(null, "Eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "No encontrado.");
        }
    }

    

    @Override
    public String toString() {
        return "Id Videojuego = " + getIdVideojuego() + "\n"+
                "Titulo = " + getTitulo() + "\n"+
                "Plataforma = " + getPlataforma() + "\n"+
                "Precio = " + getPrecio();
    }

}