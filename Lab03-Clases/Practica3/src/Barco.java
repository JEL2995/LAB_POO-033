public class Barco extends Vehiculo {

    private String tipoCasco;
    private double tonelajeMaximo;

    public Barco(String marca, String modelo, int anio,
                 double velocidadMax, String tipoCasco,
                 double tonelajeMaximo) {

        super(marca, modelo, anio, velocidadMax);

        this.tipoCasco = tipoCasco;
        this.tonelajeMaximo = tonelajeMaximo;
    }

    public String getTipoCasco() {
        return tipoCasco;
    }

    public double getTonelajeMaximo() {
        return tonelajeMaximo;
    }

    public void setTipoCasco(String tipoCasco) {
        if (tipoCasco != null && !tipoCasco.trim().isEmpty()) {
            this.tipoCasco = tipoCasco;
        } else {
            System.out.println("Error: tipo de casco no válido.");
        }
    }

    public void setTonelajeMaximo(double tonelajeMaximo) {
        if (tonelajeMaximo > 0) {
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: tonelaje máximo no válido.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Tipo de casco: " + tipoCasco
                + " | Tonelaje Máximo: " + tonelajeMaximo + " toneladas";
    }
}
