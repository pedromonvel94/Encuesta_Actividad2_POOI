import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MainEncuesta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Datos> personas = new ArrayList<>();

        System.out.println("Bienvenido a la encuesta");
        System.out.println("Por favor coloca los datos de los 5 participantes");

        for (int i = 1; i < 6; i++) {

            System.out.println("Inscripción: " + i);

            System.out.println("Ingrese su nombre: ");
            String nombre = (scanner.nextLine());

            System.out.println("Ingrese su apellido: ");
            String apellido = (scanner.nextLine());

            System.out.println("Ingrese su genero (M/F): ");
            String genero = (scanner.nextLine());
            while(true){
                if(genero.equalsIgnoreCase("femenino") || genero.equalsIgnoreCase("f") || genero.equalsIgnoreCase("masculino") || genero.equalsIgnoreCase("m")){
                    break;
                } else {
                    System.out.println("Ingrese su genero (M/F): ");
                    genero = (scanner.nextLine());
                }
            }

            System.out.println("Ingrese su edad: ");
            int edad = (scanner.nextInt());
            scanner.nextLine();

            personas.add(new Datos(nombre, apellido, genero, edad));
        }

        while(true) {
            //Printeamos la lista de opciones, que puedan seleccionar la opcion y dependiendo de la respuesta se vaya a un if o un else if, esto hacerlo dentro de un ciclo while para que puedan preguntar las veces que quieran
            System.out.println("Deseas obtener informacion de las personas registradas en la encuesta? (s/n): ");
            String respuestaPrincipal = scanner.nextLine();
            if (respuestaPrincipal.equalsIgnoreCase("n")) {
                System.out.println("Gracias por usar el programa, saliendo...");
                scanner.close();
                return;
            }

            System.out.println("Selecciona cualquiera de estas opciones (DIGITA EL NUMERO): \n 1. Nombre y genero de las personas \n 2. Promedio de las edades \n 3. Cantidad de personas de genero MASCULINO \n 4. Cantidad de personas de genero FEMENINO \n 5. Salir/Exit");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    imprimirNombreyGenero(personas);
                    break;
                case 2:
                    imprimirPromedioEdad(personas);
                    break;
                case 3:
                    imprimirCantidadHombres(personas);
                    break;
                case 4:
                    imprimirCantidadMujeres(personas);
                    break;
                case 5:
                    System.out.println("Gracias por usar el programa, saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida, por favor selecciona una opcion valida, (Numeros del 1 al 5)");
            }
        }
    }

    public static void imprimirNombreyGenero(List<Datos> personas) {
        //Usamos un ciclo for-each para recorrer cada elemento persona en la ArrayList personas
        for (Datos persona : personas) {
            //OJO, aquí estamos usando getNombre, getApellido y getGenero, para obtener el dato de cada elemento persona que vamos iterando en la ArrayList
            System.out.println("Nombre: " + persona.getNombre() + " " + persona.getApellido());
            System.out.println("Genero: " + persona.getGenero() + "\n");
        }
    }

    public static void imprimirPromedioEdad(List<Datos> personas){
        double sumaEdades = 0;
        for (Datos persona : personas) {
            sumaEdades += persona.getEdad();
        }
        double edadPromedio = sumaEdades / personas.size();
        System.out.println("La edad promedio es: " + edadPromedio +"\n");
    }

    public static void imprimirCantidadHombres(List<Datos> personas){
        int cantidadMasculino = 0;
        for (Datos persona : personas) {
            if (persona.getGenero().equalsIgnoreCase("masculino") || persona.getGenero().equalsIgnoreCase("m")) {
                cantidadMasculino++;
            }
        }
        System.out.println("La cantidad de personas del genero masculino es: " + cantidadMasculino + "\n");
    }

    public static void imprimirCantidadMujeres(List<Datos> personas){
        int cantidadFemenino = 0;
        for (Datos persona : personas) {
            if (persona.getGenero().equalsIgnoreCase("femenino") || persona.getGenero().equalsIgnoreCase("f")) {
                cantidadFemenino++;
            }
        }
        System.out.println("La cantidad de personas del genero femenino es: " + cantidadFemenino + "\n");
    }
}
