package feli.avanceiig9;
import static feli.avanceiig9.Clases.Videojuego.menuVideojuegos;
import feli.avanceiig9.Clases.Monitoreo;
import javax.swing.JOptionPane;

/**
 *
 * @author felinava06
 */
public class AvanceIIG9 {

    public static void main(String[] args) { 
        
        Monitoreo monitoreo = new Monitoreo();
        
        int opcion = 0;

        do {
            String opciones[] = {"Gestión de Videojuego", "Control de Stock", "Registro de Operaciones", "Monitoreo y Reportes", "Salir."};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion del sistema!",
                    "PowerUp Gaming!", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]) + 1;

            switch (opcion) {
                case 1:
                    menuVideojuegos();
                    break;
                case 2:
                    monitoreo.mostrarMenuMonitoreo();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
            }

        } while (opcion != 5);
    }
            
  }