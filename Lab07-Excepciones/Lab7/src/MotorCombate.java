import java.util.ArrayList;

public class MotorCombate {

    private ArrayList<String> bitacora;

    // =========================
    // CONSTRUCTOR
    // =========================

    public MotorCombate() {
        bitacora = new ArrayList<>();
    }

    // =========================
    // EJECUTAR TURNO
    // =========================

    public void ejecutarTurno(Personaje atacante, Personaje defensor) {

        // Validar atacante
        if (atacante == null) {
            throw new PersonajeNuloException(
                "ejecutarTurno(atacante)"
            );
        }

        // Validar defensor
        if (defensor == null) {
            throw new PersonajeNuloException(
                "ejecutarTurno(defensor)"
            );
        }

        System.out.println(
            "\n--- Turno: " +
            atacante.getNombre() +
            " vs " +
            defensor.getNombre() +
            " ---"
        );

        try {

            // 1. El atacante realiza su ataque
            atacante.atacar();

            // 2. Calculamos el daño
            int danio = atacante.calcularDanio();

            // 3. Aplicamos el daño al defensor
            defensor.recibirDanio(danio);

            // 4. Registrar turno exitoso
            bitacora.add(
                "OK | " +
                atacante.getNombre() +
                " atacó a " +
                defensor.getNombre() +
                " (daño: " +
                danio +
                ")"
            );

        } catch (PersonajeDerrotadoException e) {

            bitacora.add(
                "DERROTA | " +
                e.getNombrePersonaje() +
                " no pudo actuar"
            );

            System.out.println(
                "⚠ " + e.getMessage()
            );

        } catch (RecursoInsuficienteException e) {

            bitacora.add(
                "SIN RECURSO | " +
                atacante.getNombre() +
                " no pudo atacar"
            );

            System.out.println(
                "⚠ " + e.getMessage()
            );

        } catch (RpgException e) {

            bitacora.add(
                "ERROR RPG | " +
                e.getMessage()
            );

            System.out.println(
                "⚠ Error de juego: " +
                e.getMessage()
            );

        } finally {

            // Siempre se ejecuta
            System.out.println(
                "[Bitácora] Turno registrado."
            );
        }
    }

    // =========================
    // MOSTRAR BITÁCORA
    // =========================

    public void mostrarBitacora() {

        System.out.println(
            "\n=== Bitácora de Combate ==="
        );

        for (int i = 0; i < bitacora.size(); i++) {

            System.out.println(
                (i + 1) +
                ". " +
                bitacora.get(i)
            );
        }
    }
}