package teste.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.fibonacci.Fibonacci;

public class FibonacciTeste {

    @Test
    public void testeFibonacciZero() {
        int resultado = Fibonacci.findElementDP(0);
        assertEquals(0, resultado);
    }

    @Test
    public void testeFibonacciVinte() {
        int resultado = Fibonacci.findElementDP(20);
        assertEquals(6765, resultado);
    }

    @Test
    public void testeFibonacciSetenta(){
    int resultado = Fibonacci.findElementDP(70);
    assertEquals(885444751,resultado);
}

}
