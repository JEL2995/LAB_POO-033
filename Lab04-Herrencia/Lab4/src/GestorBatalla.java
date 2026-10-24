import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;

    // Constructor
    public GestorBatalla() {
        historial = new ArrayList<String>();
    }

    public void ejecutarAtaque(Personaje atacante) {

        int danio = atacante.calcularDanio();

        atacante.atacar();

        String evento =
            atacante.getNombre() +
            " atacó solo (daño: " + danio + ")";

        historial.add(evento);

        System.out.println(
            "[BATALLA] " +
            atacante.getNombre() +
            " ataca solo → daño: " +
            danio
        );
    }

    public void ejecutarAtaque(
        Personaje atacante,
        Personaje defensor) {

        int danio = atacante.calcularDanio();

        atacante.atacar();

        defensor.recibirDanio(danio);

        defensor.defender();

        String evento =
            atacante.getNombre() +
            " atacó a " +
            defensor.getNombre() +
            " (daño: " + danio + ")";

        if (!defensor.isEstaVivo()) {
            evento += " - " +
                      defensor.getNombre() +
                      " derrotado";
        }

        historial.add(evento);

        System.out.println(
            "[BATALLA] " +
            atacante.getNombre() +
            " ataca a " +
            defensor.getNombre() +
            " → daño: " +
            danio
        );
    }

    public void ejecutarAtaque(Personaje[] equipo) {

        System.out.println(
            "[BATALLA] Equipo completo ataca → " +
            equipo.length +
            " personajes"
        );

        String evento = "Ataque en equipo: ";

        for (int i = 0; i < equipo.length; i++) {

            Personaje p = equipo[i];

            int danio = p.calcularDanio();

            p.atacar();

            System.out.println(
                p.getNombre() +
                " realiza " +
                danio +
                " puntos de daño."
            );

            evento += p.getNombre();

            if (i < equipo.length - 1) {
                evento += ", ";
            }
        }

        historial.add(evento);
    }

    public void mostrarHistorial() {

        System.out.println("\n-- Historial --");

        for (int i = 0; i < historial.size(); i++) {

            System.out.println(
                (i + 1) +
                ". " +
                historial.get(i)
            );
        }
    }

    public void limpiarHistorial() {

        historial.clear();

        System.out.println(
            "El historial ha sido limpiado."
        );
    }
}
