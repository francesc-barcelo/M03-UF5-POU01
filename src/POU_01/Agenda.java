package Coleccions.Exercicis.POU_01;

import java.util.HashSet;
import java.util.Scanner;

public class Agenda
{

    /**
     * @param args
     */

    //Declaramos estas dos referencias como estáticas, para poder usarlas en todos los métodos
    static Scanner input;
    static HashSet<Persona> listaPersonas = new HashSet<>();

    public void init()
    {
        //Inicializamos la lista y la lectura por teclado
        listaPersonas = new HashSet<>(); // Perquè torna a declarar??
        listaPersonas.add(new Persona("Gerard","Torrents","93456756"));
        // listaPersonas.add(new Persona("Gerard","Torrents","75876596"));
        input = new Scanner(System.in);

        int opcion;

        do
        {
            //Al inicio de cada iteración mostramos el menú, y recogemos la opción
            menu();
            opcion = llegirInt("Escoje una opción(1-5): ", " Error: Opción no válida", 1, 5);

            switch (opcion)
            {
                case 1 -> listarPersonas();
                case 2 -> aniadirPersona();
                case 3 -> eliminarPersona();
                case 4 -> eliminarTodas();
                case 5 -> System.out.println("\n" + "Apagando aplicación...");
                default -> System.out.println("Opción no válida. Introduzca una opción válida, por favor.");
            }

        } while (opcion != 5);

        input.close();

    }

    /*
     * MÉTODO QUE IMPRIME EL MENÚ
     */
    public static void menu()
    {
        System.out.println("AGENDA DE CONTACTOS");
        System.out.println("===================");
        System.out.println("\t1. Listar todos los contactos");
        System.out.println("\t2. Añadir un contacto");
        System.out.println("\t3. Eliminar un contacto");
        System.out.println("\t4. Eliminar todos los contactos");
        System.out.println("\t5. Salir del programa\n");
        System.out.print("Introduzca una opción (1-5): ");

    }

    /*
     * MÉTODO QUE LISTA TODOS LOS CONTACTOS DE LA AGENDA
     * O MUESTRA UN MENSAJE SI NO HAY NINGUNO QUE MOSTRAR
     */
    public static void listarPersonas()
    {
        if (listaPersonas.isEmpty())
        {
            System.out.println("La agenda no tiene contactos\n");
        }
        else
        {
            int i = 0;

            for (Persona persona : listaPersonas)
            {
                ++i;
                System.out.printf("%d %s %s (%s) %n", i, persona.getNombre(), persona.getApellidos(), persona.getTelefono());
            }
            
            /* for (int i = 0; i < listaPersonas.size(); i++) {
                Persona persona = listaPersonas.get(i);
                System.out.printf("%d %s %s (%s) %n", i, persona.getNombre(), persona.getApellidos(), persona.getTelefono());
            }*/
            System.out.println("");
        }
    }

    /*
     * MÉTODO QUE RECOGE LOS DATOS DEL USUARIO
     * PARA AÑADIR UNA NUEVA PERSONA, Y LA INSERTA EN LA LISTA
     */
    public void aniadirPersona()
    {
        System.out.println("\n\nAÑADIR NUEVO CONTACTO");

        do
        {
            System.out.print("Introduzca el nombre: ");
            String nombre = input.nextLine();
            System.out.print("Introduzca los apellidos: ");
            String apellidos = input.nextLine();

            Persona nPersona = new Persona(nombre, apellidos, null);

            if (!comprovarPersonaRepetida(nPersona))
            {
                System.out.print("Introduzca su número de teléfono: ");
                String telefono = input.nextLine();

                nPersona = new Persona(nombre, apellidos, telefono);

                listaPersonas.add(nPersona);
                break;
            }
            else
            {
                System.out.println("\n" + " Error: Este contacto ya existe");
            }
        } while (true);

        System.out.println("");

    }

    private boolean comprovarPersonaRepetida(Persona nPersona)
    {
        boolean repetit = false;

        for (Persona persona : listaPersonas)
        {
            if (persona.equals(nPersona))
            {
                repetit = true;
                break;
            }
        }

        return repetit;
    }

    /*
     * MÉTODO QUE ELIMINA UNA PERSONA DE LA AGENDA
     * EN FUNCIÓN DE UNA POSICIÓN RECOGIDA DEL TECLADO
     */
    public void eliminarPersona()
    {
        System.out.println("\n\nELIMINAR CONTACTO");

        listarPersonas();

        int posicion = llegirInt("Introduzca la posición del contacto: (1-" + listaPersonas.size() + "): ", " Error: Valor no valido", 1, listaPersonas.size());
        posicion--;

        System.out.print("¿Está usted seguro de querer eliminar el contacto? (S/N): ");
        String siono = input.nextLine();

        if (siono.equalsIgnoreCase("S"))
        {
            listaPersonas.remove(posicion);
        }

        System.out.println("");
    }

    /*
     * MÉTODO QUE ELIMINA TODOS LOS CONTACTOS DE LA AGENDA
     * PREVIA CONFIRMACIÓN DE LA OPERACIÓN
     */
    public void eliminarTodas()
    {
        System.out.println("\n\nELIMINAR CONTACTO");
        System.out.print("¿Está usted seguro de querer eliminar el contacto? (S/N): ");
        String siono = input.nextLine();
        if (siono.equalsIgnoreCase("S")) {
            listaPersonas.clear();
        }
        System.out.println("");

    }

    public static int llegirInt(String missatge, String error, int min, int max)
    {
        boolean controlErrors = false;
        int valor = 0;

        do
        {
            System.out.print(missatge);
            controlErrors = input.hasNextInt();

            if (!controlErrors)
            {
                System.out.println(error);
            }
            else
            {
                valor = input.nextInt();

                if (valor < min || valor > max)
                {
                    System.out.println(error);
                    controlErrors = false;
                }
            }

            input.nextLine();
        } while (!controlErrors);

        return valor;
    }

}