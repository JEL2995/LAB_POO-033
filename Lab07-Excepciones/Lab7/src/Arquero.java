public class Arquero extends Personaje {

    private String tipoArco;
    private int precision;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida,
                   String tipoArco, int flechasDisponibles, int precision) {

        super(nombre, nivel, puntosVida);

        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    // =========================
    // ATACAR
    // =========================

    @Override
    public void atacar() throws RpgException {

        // Verificar que el arquero esté vivo
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        // Verificar que tenga flechas
        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException(
                "flechas",
                flechasDisponibles
            );
        }

        // Consumir una flecha
        flechasDisponibles--;

        System.out.println(
            "[" + getNombre() + "] dispara una flecha. " +
            "Flechas restantes: " + flechasDisponibles
        );
    }

    // =========================
    // CALCULAR DAÑO
    // =========================

    @Override
    public int calcularDanio() {
        return precision * flechasDisponibles;
    }

    // =========================
    // GETTERS
    // =========================

    public String getTipoArco() {
        return tipoArco;
    }

    public int getPrecision() {
        return precision;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "Arquero{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", estaVivo=" + estaVivo +
                ", tipoArco='" + tipoArco + '\'' +
                ", precision=" + precision +
                ", flechasDisponibles=" + flechasDisponibles +
                '}';
    }
}
