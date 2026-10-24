public class App {
    public static void main(String[] args) {

        System.out.println(
            "=== RPG - Expansión: Nuevas Clases ==="
        );


        // ==========================================
        // 1. PERSONAJE ABSTRACTO
        // ==========================================

        System.out.println(
            "\n-- Clase abstracta --"
        );

        // Esto NO se puede hacer:

        // Personaje personaje =
        //     new Personaje("Desconocido", 1, 100);

        System.out.println(
            "No se puede crear directamente un objeto " +
            "de la clase abstracta Personaje."
        );


        // ==========================================
        // 2. CREAR PERSONAJES
        // ==========================================

        Druida druida = new Druida(
            "Sylva",
            7,
            200,
            180,
            120,
            "Forma de Oso"
        );

        Nigromante nigromante = new Nigromante(
            "Malachar",
            6,
            350,
            220,
            9,
            "Maldición de decadencia"
        );

        Bardo bardo = new Bardo(
            "Finnian",
            5,
            150,
            60,
            "Laúd",
            65
        );


        // ==========================================
        // 3. POLIMORFISMO
        // ==========================================

        System.out.println(
            "\n-- Ataques y daño --"
        );

        Personaje[] equipo = {
            druida,
            nigromante,
            bardo
        };

        for (Personaje p : equipo) {

            p.atacar();

            System.out.println(
                "Daño: " +
                p.calcularDanio()
            );
        }


        // ==========================================
        // 4. INSTANCEOF + HECHICERO
        // ==========================================

        System.out.println(
            "\n-- Solo los Hechiceros lanzan hechizos --"
        );

        for (Personaje p : equipo) {

            if (p instanceof Hechicero h) {

                h.lanzarHechizo();
            }
        }


        // ==========================================
        // 5. INSTANCEOF + SANADOR
        // ==========================================

        System.out.println(
            "\n-- Solo los Sanadores curan --"
        );

        // Primero hacemos daño al Nigromante
        nigromante.recibirDanio(300);

        System.out.println();

        for (Personaje p : equipo) {

            if (p instanceof Sanador s) {

                s.curarAliado(nigromante);
            }
        }


        // ==========================================
        // 6. ESTADO FINAL
        // ==========================================

        System.out.println(
            "\n-- Estado final --"
        );

        for (Personaje p : equipo) {

            System.out.println(p);
        }
    }
}
