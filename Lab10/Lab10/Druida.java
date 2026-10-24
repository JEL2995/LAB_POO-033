public class Druida extends Personaje implements Hechicero, Sanador {
    private int mana;
    private int poderCuracion;
    private String formaNatural;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String formaNatural) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaNatural = formaNatural;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 10) throw new RecursoInsuficienteException("mana", mana);
        mana -= 10;
        System.out.println("[" + getNombre() + "] invoca raíces del bosque y ataca con furia natural.");
    }

    @Override
    public int calcularDanio() { return getNivel() * 30; }

    @Override
    public void lanzarHechizo() {
        System.out.println("[" + getNombre() + "] utiliza la magia de la naturaleza.");
    }

    @Override
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) throw new PersonajeNuloException("curarAliado");
        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        }
        aliado.puntosVida += poderCuracion;
        System.out.println("[" + getNombre() + "] cura a " + aliado.getNombre() +
                " por " + poderCuracion + " puntos de vida.");
    }

    @Override
    public int getMana() { return mana; }
    @Override
    public int getPoderCuracion() { return poderCuracion; }
    public String getFormaNatural() { return formaNatural; }
    @Override
    public String toString() { return "Druida{" + super.toString() + ", mana=" + mana +
            ", poderCuracion=" + poderCuracion + ", formaNatural=" + formaNatural + '}'; }
}
