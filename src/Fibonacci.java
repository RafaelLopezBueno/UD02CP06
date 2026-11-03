import java.util.concurrent.atomic.AtomicBoolean;

public class Fibonacci {
    private final long[] terminos;
    private final AtomicBoolean[] calculado;

    public Fibonacci(int n) {
        terminos = new long[n + 1];
        calculado = new AtomicBoolean[n + 1];
        for (int i = 0; i <= n; i++) {
            calculado[i] = new AtomicBoolean(false);
        }
    }

    public void publicar(int i, long valor) {
        terminos[i] = valor;
        calculado[i].set(true); // escritura volatil: hace visible el valor a las demas hebras
    }

    // Espera activa: se queda en bucle hasta que el termino i este calculado.
    public long esperar(int i) {
        while (!calculado[i].get()) {
            Thread.onSpinWait();
        }
        return terminos[i];
    }
}
