public class Hebra extends Thread {
    private final int id;
    private final Fibonacci fib;

    public Hebra(int id, Fibonacci fib) {
        this.id = id;
        this.fib = fib;
    }

    @Override
    public void run() {
        long valor;
        if (id == 0) {
            valor = 0;
        } else if (id == 1) {
            valor = 1;
        } else {
            long a = fib.esperar(id - 1); // espera activa
            long b = fib.esperar(id - 2); // espera activa
            valor = a + b;
        }
        fib.publicar(id, valor);
        System.out.println("Hebra " + id + ": Fibonacci(" + id + ") = " + valor);
    }
}
