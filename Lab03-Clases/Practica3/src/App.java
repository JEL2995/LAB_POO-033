public class App {
public static void main(String[] args) {

        System.out.println("=== Sistema de Transporte Multimodal ===");
        System.out.println();

        // ==========================================
        // AUTOMOVIL
        // ==========================================

        Automovil auto = new Automovil(
                "Toyota",
                "Corolla",
                2022,
                180.0,
                4,
                false
        );

        System.out.println("-- Automovil --");
        System.out.println(auto);
        System.out.println();

        // Pruebas con valores incorrectos
        auto.setAnio(1800);
        auto.setNumPuertas(10);

        System.out.println();

        // Corregimos con valores válidos
        auto.setAnio(2024);
        auto.setNumPuertas(5);

        System.out.println("-- Automovil corregido --");
        System.out.println(auto);
        System.out.println();


        // ==========================================
        // AVION
        // ==========================================

        Avion avion = new Avion(
                "Boeing",
                "737",
                2019,
                850.0,
                2,
                12500.0
        );

        System.out.println("-- Avion --");
        System.out.println(avion);
        System.out.println();

        // Prueba con valores incorrectos
        avion.setAltitudMaxima(-500);

        // Valor válido
        avion.setAltitudMaxima(13000);

        System.out.println("-- Avion corregido --");
        System.out.println(avion);
        System.out.println();


        // ==========================================
        // BARCO
        // ==========================================

        Barco barco = new Barco(
                "Ferretti",
                "550",
                2020,
                45.0,
                "Fibra de vidrio",
                25.0
        );

        System.out.println("-- Barco --");
        System.out.println(barco);
        System.out.println();

        // Prueba con valor incorrecto
        barco.setTonelajeMaximo(-10);

        // Valor válido
        barco.setTonelajeMaximo(30);

        System.out.println("-- Barco corregido --");
        System.out.println(barco);
    }
}
