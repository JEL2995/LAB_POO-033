public class App {
    public static void main(String[] args)  {
        System.out.println("=== Batalla RPG ===");

        // Crear personajes
        Guerrero guerrero = new Guerrero(
            "Thorin",
            5,
            200,
            85,
            "Cota de Malla"
        );

        Mago mago = new Mago(
            "Gandalf",
            8,
            200,
            120,
            "Fuego"
        );

        Arquero arquero = new Arquero(
            "Legolas",
            6,
            120,
            "Arco Élfico",
            95
        );



        System.out.println("\n-- Ronda 1: Ataques --");

        guerrero.atacar();

        System.out.println();

        mago.atacar();

        System.out.println();

        arquero.atacar();



        System.out.println("\n-- Ronda 2: Defensas --");

        guerrero.defender();

        mago.defender();

        arquero.defender();



        System.out.println("\n-- Daño recibido --");

        guerrero.recibirDanio(60);

        mago.recibirDanio(200);

        System.out.println("\n-- Estado final --");

        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println(arquero);
    }
}
