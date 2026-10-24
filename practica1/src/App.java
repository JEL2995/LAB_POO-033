public class App {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        int a = 5;
        int b = 3;
        System.out.println("La suma de " + a + " + " + b + " es: " + sumar(a, b));
    }
}
