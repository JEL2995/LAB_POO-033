
package com.gremio.hola_mundo.model;

public class Aventurero {

    // Atributos privados
    private String nombre;
    private String clase;
    private int nivel;

    // Constructor
    public Aventurero(String nombre, String clase, int nivel) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Obtener clase
    public String getClase() {
        return clase;
    }

    // Obtener nivel
    public int getNivel() {
        return nivel;
    }
}
