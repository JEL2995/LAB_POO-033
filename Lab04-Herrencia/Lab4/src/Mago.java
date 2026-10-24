public class Mago extends Personaje{
     private int mana;
    private String escuelaMagia;


    public Mago(String nombre, int nivel, int puntosVida,
                int mana, String escuelaMagia) {

        super(nombre, nivel, puntosVida);

        this.mana = mana;
        this.escuelaMagia = escuelaMagia;
    }


    public int getMana() {
        return mana;
    }

    public String getEscuelaMagia() {
        return escuelaMagia;
    }

    // Ataque
    @Override
    public void atacar() {

        super.atacar();

        System.out.println(
            "¡" + getNombre() +
            " lanza una bola de fuego usando " +
            mana + " puntos de maná!"
        );
    }

    // Defensa
    @Override
    public void defender() {

        System.out.println(
            getNombre() +
            " invoca un escudo arcano."
        );
    }

    @Override
    public int calcularDanio() {
        return mana * getNivel();
    }


    @Override
    public String toString() {

        return super.toString() +
               " | Maná: " + mana +
               " | Escuela de magia: " + escuelaMagia;
    }
}
