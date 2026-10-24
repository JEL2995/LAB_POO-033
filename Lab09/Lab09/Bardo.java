public class Bardo extends Personaje implements Sanador {
    private int poderCuracion;
    private String instrumento;
    private int carisma;

    public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, String instrumento, int carisma) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
        this.carisma = carisma;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        System.out.println("[" + getNombre() + "] ataca con su música de " + instrumento + ".");
    }
    @Override
    public int calcularDanio() { return carisma + 20; }
    @Override
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) throw new PersonajeNuloException("curarAliado");
        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        }
        aliado.puntosVida += poderCuracion;
        System.out.println("[" + getNombre() + "] cura a " + aliado.getNombre() + " por " + poderCuracion + ".");
    }
    @Override
    public int getPoderCuracion() { return poderCuracion; }
    public String getInstrumento() { return instrumento; }
    public int getCarisma() { return carisma; }
}
