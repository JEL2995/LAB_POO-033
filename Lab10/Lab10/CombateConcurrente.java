public class CombateConcurrente implements Runnable {
    private final String nombre;
    private final Personaje atacante;
    private final Personaje defensor;
    private final TablaResultados resultados;

    public CombateConcurrente(String nombre, Personaje atacante,
                             Personaje defensor, TablaResultados resultados) {
        if (atacante == null || defensor == null) {
            throw new PersonajeNuloException("CombateConcurrente");
        }
        if (atacante == defensor) {
            throw new IllegalArgumentException("Se requieren dos personajes distintos.");
        }
        this.nombre = nombre;
        this.atacante = atacante;
        this.defensor = defensor;
        this.resultados = java.util.Objects.requireNonNull(resultados, "resultados");
    }

    @Override
    public void run() {
        System.out.println("[" + nombre + "] INICIO - " + atacante.getNombre()
                + " vs " + defensor.getNombre());
        int rondas = 0;
        while (atacante.isEstaVivo() && defensor.isEstaVivo()) {
            try {
                Thread.sleep(500);
                System.out.println("[" + nombre + "] Ronda " + (rondas + 1));
                atacante.atacar();
                defensor.recibirDanio(atacante.calcularDanio());
                rondas++;
            } catch (RpgException e) {
                // Agotar recursos no significa que el rival haya sido derrotado.
                resultados.registrar(nombre + " -> Sin ganador: " + e.getMessage()
                        + " (rondas: " + rondas + ")");
                return;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                resultados.registrar(nombre + " -> Combate interrumpido (rondas: " + rondas + ")");
                return;
            }
        }

        String resultado;
        if (!atacante.isEstaVivo() && !defensor.isEstaVivo()) {
            resultado = "Sin ganador: ambos personajes derrotados";
        } else {
            String ganador = atacante.isEstaVivo() ? atacante.getNombre() : defensor.getNombre();
            resultado = "Ganador: " + ganador;
        }
        resultados.registrar(nombre + " -> " + resultado + " (rondas: " + rondas + ")");
        System.out.println("[" + nombre + "] FIN - " + resultado);
    }
}
