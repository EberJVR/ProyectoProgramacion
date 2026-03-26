package feli.avanceiig9.Clases;
import javax.swing.JOptionPane;

/**
 *
 * @author felinava06
 */
public class Videojuego {

    private int idVideojuego;
    private String titulo;
    private String plataforma;
    private float precio;

    public Videojuego() {
    }

    public Videojuego(int idVideojuego, String titulo, String plataforma, float precio) {
        this.idVideojuego = idVideojuego;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }
    
//    Metodos

    public static void menuVideojuegos() {
        int subOpcion = 0;
        do {
            subOpcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== GESTIÓN DE VIDEOJUEGOS ===\n"
                    + "1. Agregar Videojuego\n"
                    + "2. Consultar Datos\n"
                    + "3. Modificar Precio\n"
                    + "4. Eliminar Juego\n"
                    + "5. Volver\n"
                    + "Seleccione una opción:"
            ));

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

    public static void agregarVideojuego() {
        Videojuego videojuego = new Videojuego();
        JOptionPane.showInputDialog("Titulo del videojuego");
        JOptionPane.showInputDialog("Precio del videojuego");
        JOptionPane.showMessageDialog(null, 
            "=== Videojuego creado correctamente! ===\n" +
            "Título: " + videojuego.getTitulo() + "\n" +
            "Precio: ₡" + videojuego.getPrecio());
    }

    public static void consultarDatos() {
        Videojuego videojuego = new Videojuego();
        JOptionPane.showMessageDialog(null, 
            "=== DATOS DEL VIDEOJUEGO ===\n" +
            "ID: " + videojuego.getIdVideojuego() + "\n" +
            "Título: " + videojuego.getTitulo() + "\n" +
            "Plataforma: " + videojuego.getPlataforma() + "\n" +
            "Precio: ₡" + videojuego.getPrecio());
    }

    public static void modificarPrecio() {
        Videojuego videojuego = new Videojuego();
        JOptionPane.showInputDialog("Ingrese el nuevo precio (₡):");
        JOptionPane.showMessageDialog(null, 
            "Precio actualizado a: ₡" + videojuego.getPrecio());
    }
    
    public static void eliminarJuego() {
        Videojuego videojuego = new Videojuego();
        JOptionPane.showInputDialog("Ingrese el ID a eliminar:");
        JOptionPane.showMessageDialog(null, 
            "El registro con ID " + videojuego.getIdVideojuego() + " ha sido eliminado.");
    }


    public int getIdVideojuego() {
        return idVideojuego;
    }
    
    public int getidVideojuego() {
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
    
    
}