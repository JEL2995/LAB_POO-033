import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PersistenciaGremio {
    private static final String CARPETA = "datos_gremio";

    public PersistenciaGremio() {
        crearCarpetaSiNoExiste();
    }

    private void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA);
        if (!carpeta.exists() && carpeta.mkdir()) {
            System.out.println("[IO] Carpeta '" + CARPETA + "' creada.");
        }
        if (!carpeta.isDirectory()) {
            throw new IllegalStateException("No se puede utilizar la carpeta: " + CARPETA);
        }
    }

    public void guardarRoster(ArrayList<Personaje> roster) throws IOException {
        File archivo = new File(CARPETA, "roster.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(archivo.toPath(), StandardCharsets.UTF_8)) {
            for (Personaje p : roster) {
                writer.write(p.getNombre() + "," + p.getNivel() + "," + p.getPuntosVida());
                writer.newLine();
            }
        }
        System.out.println("[IO] Roster guardado: " + roster.size() + " personajes.");
    }

    public ArrayList<String> cargarRoster() throws IOException {
        File archivo = new File(CARPETA, "roster.txt");
        ArrayList<String> lineas = new ArrayList<>();
        if (!archivo.exists()) {
            System.out.println("[IO] roster.txt no encontrado.");
            return lineas;
        }
        try (BufferedReader reader = Files.newBufferedReader(archivo.toPath(), StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) lineas.add(linea);
            }
        }
        System.out.println("[IO] Roster cargado: " + lineas.size() + " registros.");
        return lineas;
    }

    public void guardarInventario(HashMap<String, Integer> inventario) throws IOException {
        File archivo = new File(CARPETA, "inventario.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(archivo.toPath(), StandardCharsets.UTF_8)) {
            for (Map.Entry<String, Integer> item : inventario.entrySet()) {
                writer.write(item.getKey() + "," + item.getValue());
                writer.newLine();
            }
        }
        System.out.println("[IO] Inventario guardado: " + inventario.size() + " items.");
    }

    public HashMap<String, Integer> cargarInventario() throws IOException {
        File archivo = new File(CARPETA, "inventario.txt");
        HashMap<String, Integer> inventario = new HashMap<>();
        if (!archivo.exists()) {
            System.out.println("[IO] inventario.txt no encontrado.");
            return inventario;
        }
        try (BufferedReader reader = Files.newBufferedReader(archivo.toPath(), StandardCharsets.UTF_8)) {
            String linea;
            int numeroLinea = 0;
            while ((linea = reader.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(",", -1);
                if (partes.length != 2 || partes[0].trim().isEmpty()) {
                    throw new IOException("Formato incorrecto en inventario.txt, línea " + numeroLinea);
                }
                try {
                    int cantidad = Integer.parseInt(partes[1].trim());
                    if (cantidad <= 0) throw new NumberFormatException("Cantidad no positiva");
                    inventario.put(partes[0], cantidad);
                } catch (NumberFormatException e) {
                    throw new IOException("Cantidad inválida en inventario.txt, línea " + numeroLinea, e);
                }
            }
        }
        System.out.println("[IO] Inventario cargado: " + inventario.size() + " items.");
        return inventario;
    }

    public void agregarEntradaBitacora(String entrada) throws IOException {
        File archivo = new File(CARPETA, "bitacora.txt");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(archivo, true), StandardCharsets.UTF_8))) {
            writer.write(entrada);
            writer.newLine();
        }
    }

    public void mostrarBitacora() throws IOException {
        File archivo = new File(CARPETA, "bitacora.txt");
        if (!archivo.exists()) {
            System.out.println("[IO] La bitácora está vacía.");
            return;
        }
        System.out.println("\n=== Bitácora de Batallas ===");
        try (BufferedReader reader = Files.newBufferedReader(archivo.toPath(), StandardCharsets.UTF_8)) {
            String linea;
            int numero = 1;
            while ((linea = reader.readLine()) != null) {
                System.out.println(numero++ + ". " + linea);
            }
        }
    }
}
