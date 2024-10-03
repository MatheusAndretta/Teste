package teste.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.calculadora.Calculadora;

public class CalculadoraTeste {

  

    @Test
    public void testeAdicionar(){

        int resultado = Calculadora.adicionar(10,20);
        
       assertEquals(30, resultado);

    }

    @Test
    public void testeSubtrair(){
        int resultado = Calculadora.subtrair(10,5);

        assertEquals(5, resultado);

    }

    @Test
    public void testeMultiplicar(){
        int resultado = Calculadora.multiplicar(5,9);

        assertEquals(45, resultado);
    }


    @Test
    public void testeDividir(){
        int resultado = Calculadora.dividir(6,3);
            assertEquals(2, resultado);
        }
    }




