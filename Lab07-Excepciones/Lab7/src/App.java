public class App {

    public static void main(String[] args) {

        System.out.println(
            "=== RPG - Sistema con Manejo de Excepciones ==="
        );


        // ==========================================
        // CREAR PERSONAJES
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

        Druida druida2 = new Druida(
            "Lyria",
            5,
            180,
            150,
            100,
            "Forma de Ciervo"
        );


        // Personaje que utilizaremos para probar la curación
        // de un personaje derrotado.
        Bardo personajeDerrotado = new Bardo(
            "Finnian",
            5,
            150,
            60,
            "Laúd",
            65
        );


        // Motor de combate
        MotorCombate motor = new MotorCombate();


        // ==========================================
        // ESCENARIO 1
        // Turno normal sin excepción
        // ==========================================

        System.out.println(
            "\n--- Escenario 1: Turno normal ---"
        );

        motor.ejecutarTurno(druida, nigromante);


        // ==========================================
        // ESCENARIO 2
        // Personaje derrotado intenta atacar
        // ==========================================

        System.out.println(
            "\n--- Escenario 2: Personaje derrotado ---"
        );

        // Derrotamos al druida
        try {
            druida.recibirDanio(9999);
        } catch (AccionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Ahora intenta atacar estando derrotado
        motor.ejecutarTurno(druida, nigromante);


        // ==========================================
        // ESCENARIO 3
        // Arquero sin flechas
        // ==========================================

        System.out.println(
            "\n--- Escenario 3: Arquero sin flechas ---"
        );

        Arquero sinFlechas = new Arquero(
            "Legolas",
            6,
            150,
            "Arco Largo",
            0,
            95
        );

        motor.ejecutarTurno(sinFlechas, nigromante);


        // ==========================================
        // ESCENARIO 4
        // Curar aliado derrotado
        // ==========================================

        System.out.println(
            "\n-- Intento de curar aliado derrotado --"
        );

        // Derrotamos al personaje
        try {
            personajeDerrotado.recibirDanio(9999);
        } catch (AccionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {

            druida2.curarAliado(personajeDerrotado);

        } catch (RpgException e) {

            System.out.println(
                "No se pudo curar: " +
                e.getMessage()
            );
        }


        // ==========================================
        // ESCENARIO 5
        // Daño negativo con finally
        // ==========================================

        System.out.println(
            "\n-- Bloque manual try-catch-finally --"
        );

        try {

            nigromante.recibirDanio(-50);

        } catch (AccionInvalidaException e) {

            System.out.println(
                "Capturado: " +
                e.getMessage()
            );

        } finally {

            System.out.println(
                "El bloque finally siempre se ejecuta."
            );
        }


        // ==========================================
        // ESCENARIO 6
        // Mostrar bitácora completa
        // ==========================================

        System.out.println(
            "\n=== Bitácora de Combate ==="
        );

        motor.mostrarBitacora();


        // ==========================================
        // FIN
        // ==========================================

        System.out.println(
            "\n=== Fin del programa ==="
        );
    }
}
