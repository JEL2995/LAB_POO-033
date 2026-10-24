public class Main {

    public static void main(String[] args) {
        // Por defecto muestra Lab 8. Ejecuta "java Main lab7" para las pruebas del Lab 7.
        if (args.length > 0 && args[0].equalsIgnoreCase("lab7")) {
            probarLab7();
        } else {
            probarLab8();
        }
    }

    private static void probarLab8() {
        System.out.println("=== LAB 8 - COLECCIONES DEL GREMIO RPG ===");
        GestionGremio gremio = new GestionGremio();

        // BLOQUE 1: ArrayList / roster.
        // Los constructores usan los 6 parámetros del Lab 6/7.
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, 60, "Oso"));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120, 3, "Decadencia"));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
        // Guerrero usa (nombre, nivel, vida, fuerza, armadura).
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, 80, 50));
        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }

        // BLOQUE 2: LinkedList / FIFO.
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();
        gremio.atenderSiguiente();
        gremio.mostrarCola();

        // BLOQUE 3: HashMap / inventario.
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);
        gremio.mostrarInventario();
        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();

        // BLOQUE 4: HashSet / habilidades únicas.
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");
        gremio.mostrarHabilidades();
        System.out.println("¿Tiene tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));

        // BLOQUE 5: Resumen del gremio.
        System.out.println("\n=== RESUMEN FINAL DEL GREMIO ===");
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }

    private static void probarLab7() {
        System.out.println("=== LAB 7 - RPG CON EXCEPCIONES ===");
        MotorCombate motor = new MotorCombate();
        Druida druida = new Druida("Sylva", 7, 200, 180, 120, "Oso");
        Nigromante nigromante = new Nigromante("Malachar", 6, 350, 220, 9, "Decadencia");
        Druida druida2 = new Druida("Lyria", 5, 180, 150, 100, "Ciervo");
        Bardo personajeDerrotado = new Bardo("Finnian", 5, 150, 60, "Laúd", 35);

        // Escenario 1: turno normal.
        motor.ejecutarTurno(druida, nigromante);

        // Escenario 2: atacante derrotado.
        try {
            druida.recibirDanio(9999);
            motor.ejecutarTurno(druida, nigromante);
        } catch (RpgException e) {
            System.out.println("No se pudo aplicar el daño: " + e.getMessage());
        }

        // Escenario 3: arquero sin flechas.
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);

        // Escenario 4: curar a un derrotado.
        try {
            personajeDerrotado.recibirDanio(9999);
            druida2.curarAliado(personajeDerrotado);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        // Escenario 5: daño negativo y finally.
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        // Escenario 6: bitácora.
        motor.mostrarBitacora();
    }
}
