public class Automovil extends Vehiculo {

    private int numPuertas;
    private boolean esElectrico;

    public Automovil(String marca, String modelo, int anio,
                     double velocidadMax, int numPuertas,
                     boolean esElectrico) {

        super(marca, modelo, anio, velocidadMax);

        this.numPuertas = numPuertas;
        this.esElectrico = esElectrico;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public boolean isElectrico() {
        return esElectrico;
    }

    public void setNumPuertas(int n) {
        if (n >= 2 && n <= 6) {
            this.numPuertas = n;
        } else {
            System.out.println("Error: número de puertas no válido.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Puertas: " + numPuertas
                + " | Eléctrico: " + (esElectrico ? "Sí" : "No");
    }
}
