package panaderia;

public class Panadero extends Thread{
    private final Panaderia mostrador;

    public Panadero(Panaderia mostrador) {
        this.mostrador = mostrador;
    }            

    @Override
    public void run() {
        //trabajará mientras la panadería esta abierta
        while (mostrador.isAbierta()) {            
            try {
                sleep(1000);
                mostrador.hornear();
            } catch (InterruptedException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}