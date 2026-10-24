public class App {
    public static void main(String[] args)  {
        System.out.println("=== Batalla RPG Polimorfismo ===");

        System.out.println(
            "\n-- calcularDanio() por tipo --"
        );


        Personaje p1 = new Guerrero(
            "Thorin",
            5,
            200,
            85,
            "Cota de Malla"
        );

        Personaje p2 = new Mago(
            "Gandalf",
            8,
            120,
            150,
            "Fuego"
        );

        Personaje p3 = new Arquero(
            "Legolas",
            6,
            150,
            "Arco Largo",
            30,
            95
        );

        System.out.println(
            p1.getNombre() +
            " (Guerrero) daño: " +
            p1.calcularDanio()
        );

        System.out.println(
            p2.getNombre() +
            " (Mago) daño: " +
            p2.calcularDanio()
        );

        System.out.println(
            p3.getNombre() +
            " (Arquero) daño: " +
            p3.calcularDanio()
        );

        System.out.println(
            "\n-- Arreglo polimórfico --"
        );

        Personaje[] equipo = {
            p1,
            p2,
            p3
        };

        for (Personaje p : equipo) {

            System.out.println(
                "\n" + p.getNombre() +
                " daño: " +
                p.calcularDanio()
            );

            p.atacar();
        }

        System.out.println(
            "\n-- GestorBatalla --"
        );

        GestorBatalla gestor = new GestorBatalla();

        gestor.ejecutarAtaque(p1);

        System.out.println();

        gestor.ejecutarAtaque(p2, p3);

        System.out.println();

        gestor.ejecutarAtaque(equipo);
        

        gestor.mostrarHistorial();

        System.out.println(
            "\n-- instanceof --"
        );

        for (Personaje p : equipo) {

            if (p instanceof Guerrero) {

                System.out.println(
                    p.getNombre() +
                    " es un Guerrero."
                );

            } else if (p instanceof Mago) {

                System.out.println(
                    p.getNombre() +
                    " es un Mago."
                );

            } else if (p instanceof Arquero) {

                System.out.println(
                    p.getNombre() +
                    " es un Arquero."
                );
            }
        }

        System.out.println(
            "\n-- Sobrecarga de mostrarEstado() --"
        );

        p1.mostrarEstado();

        System.out.println();

        p2.mostrarEstado(true);

        System.out.println();

        
        p3.mostrarEstado("[PERSONAJE]");
    }
}
