public class Bardo extends Personaje
        implements Sanador {

    private int poderCuracion;
    private String instrumento;
    private int carisma;

    public Bardo(
        String nombre,
        int nivel,
        int puntosVida,
        int poderCuracion,
        String instrumento,
        int carisma
    ) {

        super(nombre, nivel, puntosVida);

        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
        this.carisma = carisma;
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public int getCarisma() {
        return carisma;
    }

    @Override
    public void atacar() {

        System.out.println(
            "[" + nombre +
            "] aturde con su " +
            instrumento +
            "."
        );
    }

    @Override
    public int calcularDanio() {

        return carisma + 20;
    }

    @Override
    public void curarAliado(Personaje aliado) {

        aliado.puntosVida += poderCuracion;

        System.out.println(
            nombre +
            " entona una melodía y cura a " +
            aliado.getNombre() +
            " +" +
            poderCuracion +
            ". Vida: " +
            aliado.getPuntosVida()
        );
    }

    @Override
    public String toString() {

        return super.toString() +
               " | Poder de curación: " +
               poderCuracion +
               " | Instrumento: " +
               instrumento +
               " | Carisma: " +
               carisma;
    }

}
