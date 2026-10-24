public interface Sanador {
    // "throws RpgException" es necesario para que Druida.curarAliado lance excepciones checked.
    void curarAliado(Personaje aliado) throws RpgException;
    int getPoderCuracion();
}
