package feli.avanceiig9.Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author felinava06
 */
public class Videojuego {
    
//    Atributos
    private int idVideojuego;
    private String titulo;
    private String plataforma;
    private float precio;
    
    
//    Constructores

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
        String ops[] = {"Agregar Videojuego", "Consultar Datos", "Modificar Precio", "Eliminar", "Volver"};
        subOpcion = JOptionPane.showOptionDialog(null,
                "Seleccione una opción del menú!",
                "Gestión de Videojuegos", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]) + 1;

        switch (subOpcion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Agregando un videoJuego...");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Realizando consulta...");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Modificando precio...");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Eliminando juego...");
                break;
            case 5:
                break;
        }

    } while (subOpcion != 5);
}
    
//    Getter & Setter

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

}
