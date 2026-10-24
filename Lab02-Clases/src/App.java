import animales.Animal;
import animales.Canario;
import animales.Gato;
import animales.Perro;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Clínica Veterinaria ===\n");

        System.out.println("=== Perro ===\n");

        Animal animal1 = new Animal("Max", 5, 20.5);
        Perro perro1 = new Perro("Max", 3, 15.0, "Labrador",  true);
        System.out.println(animal1.toString() + perro1.toString());
        animal1.comer();
        perro1.ladrar();
        perro1.buscarPelota();

        System.out.println("\n=== Gato ===\n");

        Animal animal2 = new Animal("Misi", 2, 3.8);
        Gato gato1 = new Gato("Misi", 2, 3.8, "Blanco", true);
        System.out.println(animal2.toString() + gato1.toString());
        animal2.dormir();
        gato1.ronronear();

        System.out.println("\n=== Canario ===\n");
        
        Animal animal3 = new Animal("Pico", 1, 0.03);
        Canario canario1 = new Canario("Pico", 1, 0.03, "Amarillo", true);
        System.out.println(animal3.toString() + canario1.toString());
        animal3.comer();
        canario1.cantar();

    }
}
