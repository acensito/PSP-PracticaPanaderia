
package panaderia;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] nombres = {
            "Carlos", "Ana", "Luis", "Marta", "Pedro", "Sofía", "Javier", "Elena", 
            "Juan", "Laura", "David", "Sara", "Fernando", "Patricia", "José", "Carmen", 
            "Manuel", "Raquel", "Alberto", "Isabel", "Eduardo", "Sonia", "Francisco", 
            "Beatriz", "Antonio", "María", "Ricardo", "Esther", "Víctor", "Cristina", "Ángel"
        };

        Scanner teclado = new Scanner(System.in);
        Panaderia panaderia = new Panaderia();
        Panadero panadero = new Panadero(panaderia);
        Random compra = new Random();
        
        panadero.start();
        
        ArrayList <Cliente> clientes = new ArrayList<>();
        
        while (panaderia.isAbierta()) {
            System.out.println("-- Menú panadería --");
            System.out.println("1. Llegada de grupo de clientes.");
            System.out.println("2. Ver estado panaderia.");
            System.out.println("3. Cerrar la panaderia.");
            System.out.print("Introduzca una opción: ");
            
            int opcion = teclado.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    //creando un grupo de clientes
                    System.out.print("¿Cuantos clientes quieren que aborden la tienda? (máx 30): ");
                    int cantidad = teclado.nextInt();
                    for (int i = 0; i < cantidad; i++) {
                        String nombre = nombres[compra.nextInt(0, nombres.length)];
                        Cliente cliente = new Cliente(panaderia, compra.nextInt(1, 10), nombre);
                        cliente.start();
                        clientes.add(cliente);
                    }
                    
                    for (Cliente cliente : clientes) {
                        try {
                            cliente.join();
                        } catch (InterruptedException ex) {
                            System.out.println("ERROR: " + ex.getMessage());
                        }
                    }
                }
                case 2 -> panaderia.verEstado();
                case 3 -> panaderia.cerrar();
                default -> System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
            
        }
    }

}
