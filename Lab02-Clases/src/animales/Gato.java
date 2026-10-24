package animales;

public class Gato extends Animal {
    
    private String color;
    private boolean esInterior;

    public Gato(String nombre, int edad, double peso, String color, boolean esInterior) {
        super(nombre, edad, peso);
        this.color = color;
        this.esInterior = esInterior;
    }

    public void maullar() {
        System.out.println(getNombre() + " dice: ¡Miau!");
    }

    public void cazarRatones() {
        System.out.println(getNombre() + " está cazando ratones.");
    }

    public void ronronear() {
        System.out.println(getNombre() + " está ronroneando...");
    }

    @Override
    public String toString() {
        return ", color='" + color + "', Interior=" + esInterior + "}";
    }

}
