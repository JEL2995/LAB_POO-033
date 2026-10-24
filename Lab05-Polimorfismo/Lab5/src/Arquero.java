public class Arquero extends Personaje {

    private String tipoArco;
    private int precision;


    public Arquero(String nombre, int nivel, int puntosVida,
                   String tipoArco, int precision) {

        super(nombre, nivel, puntosVida);

        this.tipoArco = tipoArco;
        this.precision = precision;
    }


    public String getTipoArco() {
        return tipoArco;
    }

    public int getPrecision() {
        return precision;
    }

    // Ataque 
    @Override
    public void atacar() {

        super.atacar();

        System.out.println(
            getNombre() +
            " dispara una flecha con precisión del " +
            precision + "%."
        );
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
               " | Precisión: " + precision + "%";
    }
}
