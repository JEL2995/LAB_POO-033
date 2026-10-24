public abstract class Personaje {

    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    // Recibir daño
    public void recibirDanio(int danio) throws AccionInvalidaException {

        if (danio < 0) {
            throw new AccionInvalidaException(
            "recibirDanio",
            "El daño no puede ser negativo: " + danio
        );
    }
        puntosVida -= danio;

        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }

        System.out.println(
            nombre + " recibe " + danio +
            " puntos de daño. Vida restante: " + puntosVida
        );

        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }




    // Metodo abstracto
    public abstract void atacar() throws RpgException;

    // Metodo abstracto
    public abstract int calcularDanio();

    @Override
    public String toString() {

        String vivo = estaVivo ? "Sí" : "No";

        return "Nombre: " + nombre +
               " | Nivel: " + nivel +
               " | Vida: " + puntosVida +
               " | Vivo: " + vivo;
    }
}