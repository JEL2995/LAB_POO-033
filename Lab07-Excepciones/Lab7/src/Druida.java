public class Druida extends Personaje implements Hechicero, Sanador {

    private int mana;
    private int poderCuracion;
    private String formaNatural;

    public Druida(String nombre, int nivel, int puntosVida,
                  int mana, int poderCuracion, String formaNatural) {

        super(nombre, nivel, puntosVida);

        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaNatural = formaNatural;
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
        if (mana < 10) {
            throw new RecursoInsuficienteException(
                "mana",
                mana
            );
        }

        // 3. Consumir 10 de mana
        mana -= 10;

        // Ataque normal
        System.out.println(
            "[" + getNombre() +
            "] invoca raíces del bosque y ataca con furia natural."
        );
    }

    // =========================
    // CALCULAR DAÑO
    // =========================

    @Override
    public int calcularDanio() {
        return getNivel() * 30;
    }

    // =========================
    // LANZAR HECHIZO
    // =========================

    @Override
    public void lanzarHechizo() {
        System.out.println(
            "[" + getNombre() +
            "] utiliza la magia de la naturaleza."
        );
    }

    // =========================
    // CURAR ALIADO
    // =========================

    @Override
    public void curarAliado(Personaje aliado) throws RpgException {

        // 1. Verificar que no sea null
        if (aliado == null) {
            throw new PersonajeNuloException(
                "curarAliado"
            );
        }

        // 2. Verificar que el aliado esté vivo
        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException(
                "curarAliado",
                "No se puede curar a un personaje derrotado"
            );
        }

        // 3. Curar al aliado
        aliado.puntosVida += poderCuracion;

        System.out.println(
            "[" + getNombre() +
            "] cura a " + aliado.getNombre() +
            " por " + poderCuracion +
            " puntos de vida."
        );
    }

    // =========================
    // GETTERS
    // =========================

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public String getFormaNatural() {
        return formaNatural;
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "Druida{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", estaVivo=" + estaVivo +
                ", mana=" + mana +
                ", poderCuracion=" + poderCuracion +
                ", formaNatural='" + formaNatural + '\'' +
                '}';
    }
}