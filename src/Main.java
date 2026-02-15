import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Declaramos un scanner 
        Scanner sc = new Scanner(System.in);
        //Declaramos un Map "contactos"
        Map<String, Set<String>> contactos = new HashMap<>();

        //Declaramos un boolean "continuar" para controlar el bucle 
        boolean continuar = true;
        //A traves de un bucle while, le pedimos al usuario introducir contactos
        //que se van añadiendo al Map y se comprueba si se si ya esta incluido en 
        //la lista 
        while (continuar) {
            System.out.println("Introduce el contacto (fin para terminar): ");
            String contacto = sc.nextLine();

            if (contacto.equalsIgnoreCase("fin")) {
                continuar = false;
            } else if (contactos.containsKey(contacto) ) {
                System.out.println("El contacto ya existe");
                System.out.println("Introduce el contacto (fin para terminar): ");
                contacto = sc.nextLine();
            }else{
                Set<String> telefonos = new HashSet<>();
                boolean continuar2 = true;

                while (continuar2) {
                    System.out.println("Introduce el número de teléfono (fin para terminar): ");
                    String telefono = sc.nextLine();

                    if (telefono.equalsIgnoreCase("fin")) {
                        continuar2 = false;
                    } else {
                        telefonos.add(telefono);
                    }
                }

                contactos.putIfAbsent(contacto, telefonos);
            }
        }
        // Mostrar la agenda completa
        System.out.println("AGENDA:");
        for (Map.Entry<String, Set<String>> entry : contactos.entrySet()) {
            System.out.println("Contacto: " + entry.getKey() +
                    " | Teléfonos: " + entry.getValue());
        }

        sc.close();
    }
}
