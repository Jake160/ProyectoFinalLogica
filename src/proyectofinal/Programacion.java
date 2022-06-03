package proyectofinal;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Fecha de creacion: 9 de mayo
 *
 * @author Jose Manuel Quintero Rodriguez, Juan Angel Riaño, Jose Daniel López 
 *
 * Esta clase, representa la programación que posee cualquier sala de un
 * complejo, o la programación de todo el complejo en general.
 *
 */
public class Programacion {

    // Atributos de la clase
    int sillasReservadas;
    // Establecemos el formato de la hora para el horario
    String nombrePelicula, horario;
    int numeroSala;

    Pelicula pl = new Pelicula();
    Complejo cp = new Complejo();
    Sala sl = new Sala();
    boolean sillas[][] = new boolean[sl.cantidadFilas][sl.sillasPorFila];

    /*Este método constructor se encarga de realizar asignación de valores a los atributos
    @author Jose Manuel Quintero Rodriguez*/
    public Programacion(int ns) {
        this.numeroSala = ns;
        nombrePelicula = "";
        horario = "";
    }

    public void crearProgramacion() {
        // Creamos una lista de arreglos que tomará los id de las salas
        try {
            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Hay un error de tipo " + e);
        }
        for (int i = 0; i < cp.salas.length; i++) {
//            numeroSala = (JOptionPane.showInputDialog(null, "Elija el numero de la sala", "Salas",
//                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Seleccionar", listaSalas}, "")).toString();
        }
        
        numeroSala = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de la sala para programacion"));
        nombrePelicula = JOptionPane.showInputDialog("Ingrese nombre de la pelicula");
        horario = JOptionPane.showInputDialog("Especifique el horario para esta programacion");
        // Generar el mapa de la sala sin asientos ocupados
        for (int i = 0; i < sl.cantidadFilas; i++) {
            for (int j = 0; j < sl.sillasPorFila; j++) {
                sillas[i][j] = true;
            }
        }
        String espacios = "";
        for (int i = 0; i < sl.cantidadFilas; i++) {
            for (int j = 0; j < sl.sillasPorFila; j++) {
                espacios += sillas[i][j] + " ";
            }
            espacios += "\n";
        }
        JOptionPane.showMessageDialog(null, espacios);
    }

    // Metodo nuevo de hoy 2 de junio
    public void reservarAsiento(int id) {
        boolean seEncontroSala = true;
        int espFila, espColumna;
        for (int i = 0; i < cp.salas.length; i++) {
            if (id == cp.salas[i].numeroSala) {
                seEncontroSala = true;
                do {
                    espFila = Integer.parseInt(JOptionPane.showInputDialog("Dime el numero de fila"));
                    if (espFila < 0 || espFila > sillas.length - 1) {
                        JOptionPane.showMessageDialog(null, "No se permite el número", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } while (espFila < 0 || espFila > sillas.length - 1);
                do {
                    espColumna = Integer.parseInt(JOptionPane.showInputDialog("Dime el numero de columna"));
                    if (espColumna < 0 || espColumna > sillas[0].length - 1) {
                        JOptionPane.showMessageDialog(null, "No se permite el número", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } while (espColumna < 0 || espColumna > sillas[0].length - 1);
                sillas[espFila][espColumna] = false;
            }
        }
        if (seEncontroSala == false) {
            JOptionPane.showMessageDialog(null, "No se encontró la sala", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            String cadena = "";
            for (int i = 0; i < sillas.length; i++) {
                for (int j = 0; j < sillas[0].length; j++) {
                    cadena += sillas[i][j] + " ";
                }
                cadena += "\n";
            }
            JOptionPane.showMessageDialog(null, cadena);
        }
    }

    /*Método encargado de mostrar el mapa de una sala en un estado temporal durante la programacion de un filme*/
    public void mostrarMapaProgramado(int idSala) {
        boolean existencia = false;
        String muestreMapa = "";
        for (int i = 0; i < cp.salas.length; i++) { // Recorremos el arreglo de la sala
            if (cp.salas[i] != null) { // Verificamos si la sala existe
                if (cp.salas[i].numeroSala == idSala) { // Verificamos si existe la sala
                    existencia = true;
                    for (int j = 0; j < cp.salas[i].cantidadFilas; j++) {
                        for (int k = 0; k < cp.salas[i].sillasPorFila; k++) {
                            try {
                                muestreMapa += sl.programaciones[i].sillas[j][k] + " ";
                            } catch (NullPointerException ex) {
                                JOptionPane.showMessageDialog(null, "No existen programaciones registradas");
                            }
                        }
                        muestreMapa += "\n";
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay salas registradas en este complejo", "ERROR", JOptionPane.ERROR_MESSAGE);
                break; // Rompemos el ciclo inmediatamente sacandonos del ciclo
            }
        } // En caso de que la existencia de esa sala especifica sea falsa
        if (existencia == true) {
            JOptionPane.showMessageDialog(null, muestreMapa);
        }
    }
}
