public class Arquero extends Personaje {

    private String tipoArco;
    private int precision;
    private int flechasDisponibles;


    public Arquero(String nombre, int nivel, int puntosVida,
                   String tipoArco, int precision, int flechasDisponibles) {

        super(nombre, nivel, puntosVida);

        this.tipoArco = tipoArco;
        this.precision = precision;
        this.flechasDisponibles = flechasDisponibles;
    }


    public String getTipoArco() {
        return tipoArco;
    }

    public int getPrecision() {
        return precision;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    // Ataque 
    @Override
    public void atacar() {

        super.atacar();

        if (flechasDisponibles > 0) {

            flechasDisponibles--;

            System.out.println(
                getNombre() +
                " dispara una flecha con precisión del " +
                precision + "%."
            );

            System.out.println(
                "Flechas restantes: " +
                flechasDisponibles
            );

        } else {

            System.out.println(
                getNombre() +
                " no tiene flechas disponibles."
            );
        }
    }

    // Defensa 
    @Override
    public void defender() {

        System.out.println(
            getNombre() +
            " se desplaza ágilmente esquivando el ataque."
        );
    }

    @Override
    public String toString() {

        return super.toString() +
               " | Tipo de arco: " + tipoArco +
               " | Flechas: " + flechasDisponibles +
               " | Precisión: " + precision + "%";
    }
}
