public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int almasAbsorbidas;
    private String maldicion;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas, String maldicion) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.maldicion = maldicion;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 15) throw new RecursoInsuficienteException("mana", mana);
        mana -= 15;
        System.out.println("[" + getNombre() + "] lanza una maldición oscura contra su enemigo.");
    }

    @Override
    public int calcularDanio() { return getNivel() * 50 + almasAbsorbidas * 10; }
    @Override
    public void lanzarHechizo() {
        System.out.println("[" + getNombre() + "] utiliza el hechizo: " + maldicion);
    }
    @Override
    public int getMana() { return mana; }
    public int getAlmasAbsorbidas() { return almasAbsorbidas; }
    public String getMaldicion() { return maldicion; }
    @Override
    public String toString() { return "Nigromante{" + super.toString() + ", mana=" + mana +
            ", almasAbsorbidas=" + almasAbsorbidas + ", maldicion=" + maldicion + '}'; }
}
