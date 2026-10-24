public class Arquero extends Personaje {
    private String tipoArco;
    private int precision;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int flechasDisponibles, int precision) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }
        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha. Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public int calcularDanio() { return precision * flechasDisponibles; }
    public String getTipoArco() { return tipoArco; }
    public int getPrecision() { return precision; }
    public int getFlechasDisponibles() { return flechasDisponibles; }
    @Override
    public String toString() { return "Arquero{" + super.toString() + ", tipoArco=" + tipoArco +
            ", precision=" + precision + ", flechasDisponibles=" + flechasDisponibles + '}'; }
}
