package animales;

public class Canario extends Animal {
    private String colorPlumaje;
    private boolean canta;

    public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean canta) {
        super(nombre, edad, peso);
        this.colorPlumaje = colorPlumaje;
        this.canta = canta;
    }

    public void cantar() {
        if (canta) {
            System.out.println(getNombre() + " está cantando. PI PI PI!");
        } else {
            System.out.println(getNombre() + " no puede cantar.");
        }
    }

    @Override
    public String toString() {
        return ", color='" + colorPlumaje + "', Canta=" + canta + "}";
    }

}
