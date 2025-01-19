
package panaderia;

public class Panaderia {
    private int mostrador = 20;
    private double recaudacion = 0;
    private int ventas = 0;
    private boolean estado = true;
    
    public synchronized void hornear() {
        //comprueba si el numero de barras ha descendido
        if (mostrador < 10) {
            try {
                //notificamos que ponemos a hornear 20 barras
                System.err.println("El panadero horneando 20 barras ...");
                //esperamos 20 segundos
                Thread.sleep(20000);
                //lo horneado lo mandamos al mostrador
                mostrador = mostrador + 20;
                System.err.println("Panadero terminó de hornear. Barras disponibles: " + mostrador);
            } catch (InterruptedException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
            //notificamos que finalizamos al resto de hilos
            notifyAll();
        }
        
    }
    
    public synchronized void comprar(String cliente, int cantidad) {
        //mientras la cantidad existente en el mostrador no sea la que puede comprar 
        //el cliente, espera a que haya disponibilidad.
        while (mostrador < cantidad) {
            try {
                System.out.println(cliente + " espera una hornada de barras.");
                wait();
            } catch (InterruptedException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        //quitamos al mostrador la cantidad de barras que se ha comprado
        mostrador -= cantidad;
        //sumamos al numero de ventas totales el numero de barras vendidas
        ventas += cantidad;
        //calculamos el precio de lo comprado por el cliente
        double compra = 1 + (cantidad - 1) * 0.75;
        //lo sumamos a la recaudacion total
        recaudacion += compra;
        System.out.println(cliente + " compró " + cantidad + " barras por " + compra + "€. Barras restantes: " + mostrador);
        //notificamos que finalizamos al resto de hilos
        notifyAll();
    }

    public synchronized void cerrar() {
        System.out.println("Cerrando panadería...");
        System.out.println("El panadero se lleva " + mostrador + " barras a su casa.");
        mostrador = 0;
        hornear();
        estado = false;
        System.out.println("Resumen: Barras vendidas: " + (ventas));
        System.out.println("Total recaudado: " + recaudacion + "€");
    }
    
    public synchronized void verEstado() {
        System.out.println("Barras disponibles: " + mostrador);
        System.out.println("Total recaudado: " + recaudacion + "€");
        System.out.println("Total barras horneadas: " + ventas);
    }
    
    public boolean isAbierta() {
        return estado;
    }

}