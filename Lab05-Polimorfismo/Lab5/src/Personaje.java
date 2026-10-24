public class Personaje implements Combatiente {

    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

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
    public void recibirDanio(int danio) {

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

    // Metodo generico de ataque
    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con un golpe básico.");
    }

    // Metodo generico de defensa
    @Override
    public void defender() {
        System.out.println(nombre + " se pone en guardia.");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               " | Nivel: " + nivel +
               " | Vida: " + puntosVida +
               " | Vivo: " + (estaVivo ? "Sí" : "No");
    }
}