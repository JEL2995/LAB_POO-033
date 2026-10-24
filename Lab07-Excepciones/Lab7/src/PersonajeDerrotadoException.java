public class PersonajeDerrotadoException extends RpgException{

    private String nombrePersonaje;

    public PersonajeDerrotadoException(String nombrePersonaje) {
        super("El personaje " + nombrePersonaje + " ha sido derrotado y no puede hacer esta accion");
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }
    
}
