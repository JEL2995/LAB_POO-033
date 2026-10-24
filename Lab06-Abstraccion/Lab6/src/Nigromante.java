public class Nigromante extends Personaje 
        implements Hechicero{
    private int mana;
    private int almasAbsorbidas;
    private String maldicion;

    public Nigromante(
        String nombre,
        int nivel,
        int puntosVida,
        int mana,
        int almasAbsorbidas,
        String maldicion
    ) {

        super(nombre, nivel, puntosVida);

        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.maldicion = maldicion;
    }

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

    @Override
    public void atacar() {

        System.out.println(
            "[" + nombre +
            "] drena la esencia vital."
        );
    }

    @Override
    public int calcularDanio() {

        return (nivel * 50) + (almasAbsorbidas * 10);
    }

        @Override
    public void lanzarHechizo() {

        System.out.println(
            nombre +
            " lanza: ¡" +
            maldicion +
            "! (maná: " +
            mana +
            ")"
        );
    }

    @Override
    public String toString() {

        return super.toString() +
               " | Maná: " + mana +
               " | Almas absorbidas: " +
               almasAbsorbidas +
               " | Maldición: " +
               maldicion;
    }

    
}
