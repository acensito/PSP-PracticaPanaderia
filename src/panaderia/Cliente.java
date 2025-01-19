package panaderia;



public class Cliente extends Thread {
    private final Panaderia panaderia;
    private final int compra;

    public Cliente(Panaderia panaderia, int compra, String name) {
        super(name);
        this.panaderia = panaderia;
        this.compra = compra;
    }

    @Override
    public void run() {
        panaderia.comprar(getName(), compra);
    }

}