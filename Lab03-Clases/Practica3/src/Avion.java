public class Avion extends Vehiculo {

    private int numMotores;
    private double altitudMaxima;

    public Avion(String marca, String modelo, int anio,
                 double velocidadMax, int numMotores,
                 double altitudMaxima) {

        super(marca, modelo, anio, velocidadMax);

        this.numMotores = numMotores;
        this.altitudMaxima = altitudMaxima;
    }

    public int getNumMotores() {
        return numMotores;
    }

    public double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setNumMotores(int numMotores) {
        if (numMotores > 0) {
            this.numMotores = numMotores;
        } else {
            System.out.println("Error: número de motores no válido.");
        }
    }

    public void setAltitudMaxima(double altitudMaxima) {
        if (altitudMaxima >= 0) {
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: la altitud máxima no puede ser negativa.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Motores: " + numMotores
                + " | Altitud Máxima: " + altitudMaxima + " m";
    }
}