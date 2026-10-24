public class Main {

    public static void main(String[] args) {
        // Lab 9 por defecto. Los laboratorios anteriores siguen disponibles.
        if (args.length > 0 && args[0].equalsIgnoreCase("lab7")) {
            probarLab7();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("lab8")) {
            probarLab8();
        } else {
            probarLab9();
        }
    }

    private static void probarLab9() {
        System.out.println("=== LAB 9 - PERSISTENCIA DEL GREMIO RPG ===");
        try {
            PersistenciaGremio persistencia = new PersistenciaGremio();


            System.out.println("\n=== Datos encontrados al iniciar ===");
            java.util.ArrayList<String> anteriores = persistencia.cargarRoster();
            java.util.HashMap<String, Integer> inventarioAnterior = persistencia.cargarInventario();
            System.out.println("Personajes anteriores: " + anteriores.size());
            System.out.println("Artículos anteriores: " + inventarioAnterior.size());

            java.util.ArrayList<Personaje> roster = new java.util.ArrayList<>();
            roster.add(new Druida("Sylva", 10, 300, 100, 60, "Oso"));
            roster.add(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
            roster.add(new Guerrero("Thorin", 9, 400, 80, 50));
            persistencia.guardarRoster(roster);

            // BLOQUE 2: Recuperar y presentar las líneas de roster.txt.
            java.util.ArrayList<String> lineasRoster = persistencia.cargarRoster();
            System.out.println("\n=== Roster cargado desde archivo ===");
            for (String linea : lineasRoster) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    System.out.println("Nombre: " + partes[0] +
                            " | Nivel: " + partes[1] + " | Vida: " + partes[2]);
                } else {
                    System.out.println("Registro con formato inválido: " + linea);
                }
            }

            java.util.HashMap<String, Integer> inventario = new java.util.HashMap<>();
            inventario.put("Poción de vida", 8);
            inventario.put("Flecha élfica", 30);
            inventario.put("Pergamino de fuego", 3);
            persistencia.guardarInventario(inventario);
            java.util.HashMap<String, Integer> inventarioCargado = persistencia.cargarInventario();
            System.out.println("\n=== Inventario cargado desde archivo ===");
            for (java.util.Map.Entry<String, Integer> item : inventarioCargado.entrySet()) {
                System.out.println(item.getKey() + " -> " + item.getValue());
            }

            persistencia.agregarEntradaBitacora("Sylva atacó a Malachar (daño: 240)");
            persistencia.agregarEntradaBitacora("Legolas sin flechas - no pudo atacar");
            persistencia.agregarEntradaBitacora("Thorin venció a Dragón de Hielo");
            persistencia.mostrarBitacora();

            java.io.File carpeta = new java.io.File("datos_gremio");
            System.out.println("\n=== Archivos en datos_gremio/ ===");
            java.io.File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (java.io.File f : archivos) {
                    if (f.isFile()) {
                        System.out.println(f.getName() + " (" + f.length() + " bytes)");
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }

    private static void probarLab8() {
        System.out.println("=== LAB 8 - COLECCIONES DEL GREMIO RPG ===");
        GestionGremio gremio = new GestionGremio();


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

        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();
        gremio.atenderSiguiente();
        gremio.mostrarCola();


        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);
        gremio.mostrarInventario();
        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();

        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");
        gremio.mostrarHabilidades();
        System.out.println("¿Tiene tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));


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


        motor.ejecutarTurno(druida, nigromante);


        try {
            druida.recibirDanio(9999);
            motor.ejecutarTurno(druida, nigromante);
        } catch (RpgException e) {
            System.out.println("No se pudo aplicar el daño: " + e.getMessage());
        }


        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);


        try {
            personajeDerrotado.recibirDanio(9999);
            druida2.curarAliado(personajeDerrotado);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }


        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        motor.mostrarBitacora();
    }
}
