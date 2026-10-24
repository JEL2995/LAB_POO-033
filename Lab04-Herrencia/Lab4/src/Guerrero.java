public class Guerrero extends Personaje {
    private int fuerza;
    private String armadura;


    public Guerrero(String nombre, int nivel, int puntosVida,
                    int fuerza, String armadura) {

        super(nombre, nivel, puntosVida);

        this.fuerza = fuerza;
        this.armadura = armadura;
    }


    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    // Ataque 
    @Override
    public void atacar() {

        // Ejecuta primero el metodo del padre
        super.atacar();

        System.out.println(
            "¡" + getNombre() +
            " golpea con su espada causando " +
            fuerza + " de daño!"
        );
    }

    // Defensa
    @Override
    public void defender() {

        System.out.println(
            getNombre() +
            " bloquea con su armadura de " +
            armadura + "."
        );
    }

    @Override
    public int calcularDanio() {
        return fuerza * getNivel();
    }

    @Override
    public String toString() {

        return super.toString() +
               " | Fuerza: " + fuerza +
               " | Armadura: " + armadura;
    }
    
}
