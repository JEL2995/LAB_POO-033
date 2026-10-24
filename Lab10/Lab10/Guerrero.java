public class Guerrero extends Personaje {
    private int fuerza;
    private int armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, int armadura) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        System.out.println("[" + getNombre() + "] ataca con su arma.");
    }
    @Override
    public int calcularDanio() { return fuerza * getNivel(); }
    public int getFuerza() { return fuerza; }
    public int getArmadura() { return armadura; }
}
