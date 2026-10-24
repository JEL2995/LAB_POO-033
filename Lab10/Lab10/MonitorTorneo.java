public class MonitorTorneo extends Thread {
    private final String nombreCampo;
    private final int duracionSegundos;

    public MonitorTorneo(String nombreCampo, int duracionSegundos) {
        super("Monitor-" + nombreCampo);
        this.nombreCampo = nombreCampo;
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public void run() {
        System.out.println("[Monitor] Vigilando campo: " + nombreCampo);
        for (int i = 1; i <= duracionSegundos; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("[Monitor] " + nombreCampo + " - segundo " + i
                        + " de " + duracionSegundos);
            } catch (InterruptedException e) {
                System.out.println("[Monitor] Monitor interrumpido.");
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("[Monitor] " + nombreCampo + " finalizado.");
    }
}
