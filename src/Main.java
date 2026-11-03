
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 10; // termino N-esimo que se quiere calcular (maximo 90 para long)
        Fibonacci fib = new Fibonacci(n);

        Hebra[] hebras = new Hebra[n + 1];
        // Se lanzan en orden inverso para demostrar que las hebras esperan a las anteriores
        for (int i = n; i >= 0; i--) {
            hebras[i] = new Hebra(i, fib);
            hebras[i].start();
        }
        for (Hebra h : hebras) {
            h.join();
        }
        System.out.println("El termino " + n + " de la sucesion de Fibonacci es " + fib.esperar(n));
    }
}
