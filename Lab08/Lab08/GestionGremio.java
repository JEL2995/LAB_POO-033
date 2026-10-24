import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GestionGremio {

    private ArrayList<Personaje> roster;
    private LinkedList<String> colaTurnos;
    private HashMap<String, Integer> inventario;
    private HashSet<String> habilidades;

    public GestionGremio() {
        roster = new ArrayList<>();
        colaTurnos = new LinkedList<>();
        inventario = new HashMap<>();
        habilidades = new HashSet<>();
    }

    // PARTE 1: ArrayList - roster de personajes
    public void agregarMiembro(Personaje p) {
        if (p == null) {
            throw new PersonajeNuloException("agregarMiembro");
        }
        roster.add(p);
        System.out.println("[Gremio] " + p.getNombre() + " se unió al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator<Personaje> it = roster.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                System.out.println("[Gremio] " + nombre + " abandonó el gremio.");
                return;
            }
        }
        System.out.println("[Gremio] No se encontró: " + nombre);
    }

    public Personaje buscarPorNombre(String nombre) {
        for (Personaje p : roster) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println("\n=== Roster del Gremio (" + roster.size() + " miembros) ===");
        for (int i = 0; i < roster.size(); i++) {
            Personaje p = roster.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() +
                    " | Nivel: " + p.getNivel() +
                    " | Vida: " + p.getPuntosVida());
        }
    }

    // PARTE 2: LinkedList - cola FIFO
    public void encolarSolicitante(String nombre) {
        colaTurnos.addLast(nombre);
        System.out.println("[Cola] " + nombre + " en posición " + colaTurnos.size());
    }

    public String atenderSiguiente() {
        if (colaTurnos.isEmpty()) {
            System.out.println("[Cola] No hay solicitantes en espera.");
            return null;
        }
        String atendido = colaTurnos.removeFirst();
        System.out.println("[Cola] Atendiendo a: " + atendido);
        return atendido;
    }

    public void mostrarCola() {
        System.out.println("\n=== Cola de Espera (" + colaTurnos.size() + ") ===");
        int posicion = 1;
        for (String nombre : colaTurnos) {
            System.out.println(posicion++ + ". " + nombre);
        }
    }

    // PARTE 3a: HashMap - inventario
    public void agregarItem(String item, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("[Inventario] La cantidad debe ser mayor que cero.");
            return;
        }
        int total = inventario.getOrDefault(item, 0) + cantidad;
        inventario.put(item, total);
        System.out.println("[Inventario] " + item + ": " + total);
    }

    public void usarItem(String item) {
        Integer cantidad = inventario.get(item);
        if (cantidad == null || cantidad <= 0) {
            System.out.println("[Inventario] No existe en inventario: " + item);
            return;
        }
        int restante = cantidad - 1;
        if (restante == 0) {
            inventario.remove(item);
        } else {
            inventario.put(item, restante);
        }
        System.out.println("[Inventario] " + item + " usado. Restante: " + restante);
    }

    public void mostrarInventario() {
        System.out.println("\n=== Inventario del Gremio ===");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // PARTE 3b: HashSet - habilidades sin duplicados
    public void registrarHabilidad(String habilidad) {
        boolean nueva = habilidades.add(habilidad);
        if (nueva) {
            System.out.println("[Habilidades] " + habilidad + " registrada.");
        } else {
            System.out.println("[Habilidades] " + habilidad + " ya estaba registrada.");
        }
    }

    public boolean tieneHabilidad(String habilidad) {
        return habilidades.contains(habilidad);
    }

    public void mostrarHabilidades() {
        System.out.println("\n=== Habilidades del Gremio ===");
        for (String habilidad : habilidades) {
            System.out.println("- " + habilidad);
        }
    }
}
