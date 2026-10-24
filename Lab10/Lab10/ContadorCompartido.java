public class ContadorCompartido {
    private int contador = 0;

    // Intencionalmente inseguro: leer, sumar y escribir no es una operacion atomica.
    public void incrementar() {
        contador++;
    }

    public synchronized void incrementarSeguro() {
        contador++;
    }

    // Main consulta o reinicia solo despues de esperar a todos los hilos con join().
    public int getContador() {
        return contador;
    }

    public void resetear() {
        contador = 0;
    }
}
