package proyectofinal;

import javax.swing.JOptionPane;

/**
 * Fecha de creacion: 3 de mayo
 *
 * @author Jose Manuel Quintero Rodríguez
 *
 * Esta clase se encarga de pedir los datos correspodientes a una sala, teniendo
 * en cuenta que para registrar una sala tiene que haber al menos un complejo
 * registrado, en donde al suministrar los datos correspodiente detallamos la
 * forma en como será el mapa de respectiva sala, esta clase también se encarga
 * de calcular el porcentaje de ocupación.
 */
public class Sala {

    // Se tienen los atributos respectivos de la clase
    int numeroSala, cantidadFilas, sillasPorFila;
    double valorBoleta;

    // Declaramos el arreglo de programaciones que serán como máximo 5
    Programacion programaciones[] = new Programacion[5];

    /*Este es el método constructor de la clase que se encarga de inicializar los valoes
    de los atributos. Cabe destacar que la inicializacion tambien sirve para que al momento de
    crear un objeto de tipo Sala y guardarlo en un arreglo de objetos, este no se almacene con datos nulos
    @author José Manuel Quintero Rodriguez*/
    public Sala() {
        numeroSala = 0;
        cantidadFilas = 5;
        sillasPorFila = 5;
        valorBoleta = 0;
    }

    /* Este método se encarga de solicitar los datos de la sala además de definir el diseño del mapa de la sala
    @author Jose Manuel Quintero Rodriguez */
    public void pedirInfoSala() {
        // El identificador de la sala se volverá autoincrementable
        numeroSala = Integer.parseInt(JOptionPane.showInputDialog("Ingrese identificador de la sala"));
        do {
            valorBoleta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese valor de la boleta"));
            if (valorBoleta < 0) {
                JOptionPane.showMessageDialog(null, "No se permiten valores negativos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (valorBoleta < 0);
        for (int i = 0; i < programaciones.length; i++) {
            if (programaciones[i] == null) {
                programaciones[i] = new Programacion(numeroSala);
                programaciones[i].crearProgramacion();
            }
        }
    }

    /* Este metodo se encarga de mostrar la programación que tiene la sala para un día
    @author Jose Manuel Quintero Rodriguez*/
    public void mostrarProgramacion() {
        // Creamos un arreglo que almacenara un listado de peliculas en cartelera
        String listadoPeliculas = "";
        boolean existencia = false;
        for (int i = 0; i < programaciones.length; i++) { // Recorremos el arreglo de peliculas
            if (programaciones[i] != null) { // Verificamos que el objeto Pelicula en la posición indicada, exista en el arreglo
                if (programaciones[i].pl.actividad == true) { // Indicamos si la pelicula está activa para agregarla a la programación
                    existencia = true;
                    listadoPeliculas += (i + 1) + ". " + programaciones[i].pl.nomEspanol
                            + "\nHorario: " + programaciones[i].horario + "\nNumero de la sala: " + numeroSala;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede mostrar la programación\n"
                        + "si no hay peliculas registradas", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
            }
        } // Mostramos el listado con la programación
        if (existencia == true) {
            JOptionPane.showMessageDialog(null, listadoPeliculas);
        }
    }
    
    /* Este método se encarga de calcular el porcetaje de ocupación en una sala especifica
    tomando como parametro de entrada el numero de personas que visitaron dicha sala
    @author Jose Manuel Quintero Rodriguez */
    public double calcularPorcOcupacion(int nPersonas) {
        double porcentaje = 0;
        // Verfificamos que la cantidad de personas no sea mayor al numero de sillas de la sala
        if (nPersonas > (cantidadFilas * sillasPorFila)) {
            JOptionPane.showMessageDialog(null, "No pueden haber mas personas que sillas en la sala", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            porcentaje = nPersonas * 100 / (cantidadFilas * sillasPorFila);
        }
        return porcentaje;
    }
}
