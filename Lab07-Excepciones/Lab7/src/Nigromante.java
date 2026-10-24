public class Nigromante extends Personaje implements Hechicero {

    private int mana;
    private int almasAbsorbidas;
    private String maldicion;

    public Nigromante(String nombre, int nivel, int puntosVida,
                      int mana, int almasAbsorbidas,
                      String maldicion) {

        super(nombre, nivel, puntosVida);

        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.maldicion = maldicion;
    }

    // =========================
    // ATACAR
    // =========================

    @Override
    public void atacar() throws RpgException {

        // 1. Verificar si está vivo
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(
                getNombre()
            );
        }

        // 2. Verificar mana suficiente
        if (mana < 15) {
            throw new RecursoInsuficienteException(
                "mana",
                mana
            );
        }

        // 3. Consumir 15 de mana
        mana -= 15;

        // Ataque normal
        System.out.println(
            "[" + getNombre() +
            "] lanza una maldición oscura contra su enemigo."
        );
    }

    // =========================
    // CALCULAR DAÑO
    // =========================

    @Override
    public int calcularDanio() {
        return (getNivel() * 50) +
               (almasAbsorbidas * 10);
    }

    // =========================
    // LANZAR HECHIZO
    // =========================

    @Override
    public void lanzarHechizo() {
        System.out.println(
            "[" + getNombre() +
            "] utiliza el hechizo: " +
            maldicion
        );
    }

    // =========================
    // GETTERS
    // =========================

    @Override
    public int getMana() {
        return mana;
    }

    public int getAlmasAbsorbidas() {
        return almasAbsorbidas;
    }

    public String getMaldicion() {
        return maldicion;
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "Nigromante{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", estaVivo=" + estaVivo +
                ", mana=" + mana +
                ", almasAbsorbidas=" + almasAbsorbidas +
                ", maldicion='" + maldicion + '\'' +
                '}';
    }
}